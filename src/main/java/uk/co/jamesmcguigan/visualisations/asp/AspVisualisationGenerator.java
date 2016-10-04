package uk.co.jamesmcguigan.visualisations.asp;

import org.apache.commons.io.FileUtils;
import uk.co.jamesmcguigan.visualisations.VisualisationGenerator;
import uk.co.jamesmcguigan.visualisations.aem.EntityFactory;
import uk.co.jamesmcguigan.visualisations.infrastructure.AbstractEntityRepository;
import uk.co.jamesmcguigan.visualisations.infrastructure.Entity;

import javax.jcr.Node;
import javax.jcr.RepositoryException;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.MalformedInputException;
import java.nio.file.Files;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AspVisualisationGenerator implements VisualisationGenerator {

    public void create() {
        final File dir = new File("C:\\code\\travelinsurance\\src\\main\\admin_classic_asp\\");
        final Collection<File> files = FileUtils.listFiles(dir, new String[]{"asp"}, true);

        for (File file : files) {
            try {
                List<String> contents;
                try {
                    contents = Files.readAllLines(file.toPath(), Charset.forName("UTF-8"));
                } catch (MalformedInputException ex) {
                    contents = Files.readAllLines(file.toPath(), Charset.forName("iso-8859-1"));
                }

                for (String content : contents) {
                    //<!--#include file="../inc/msaldboc.asp"-->
                    //last index
                    Pattern p = Pattern.compile("<!--#include file=\"[\\./]*(.*)\"-->");
                    Matcher m = p.matcher(content);
                    if (m.find()) {
                        String filename = m.group();
                        System.out.println(filename);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private Entity addCurrentNode(final Node currentNode, final AbstractEntityRepository entityRepository) throws RepositoryException {
        Entity entity = entityRepository.find(currentNode.getName());
        if (entity == null) {
            entity = (Entity) entityRepository.createOrUpdate(EntityFactory.createEntity(currentNode));
        }
        return entity;
    }
}
