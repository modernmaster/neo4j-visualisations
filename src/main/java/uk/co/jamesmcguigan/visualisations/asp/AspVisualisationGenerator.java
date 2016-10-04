package uk.co.jamesmcguigan.visualisations.asp;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import uk.co.jamesmcguigan.visualisations.VisualisationGenerator;
import uk.co.jamesmcguigan.visualisations.infrastructure.AbstractEntityRepository;

import java.io.File;
import java.io.IOException;
import java.nio.charset.MalformedInputException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AspVisualisationGenerator implements VisualisationGenerator {

    public static final String UNABLE_TO_PARSE_FILE = "Unable to parse file";
    private AbstractEntityRepository pageRepository;
    private final static Logger LOGGER = LoggerFactory.getLogger(AspVisualisationGenerator.class);

    public AspVisualisationGenerator() {
        pageRepository = new PageRepository();
    }

    public void create(final String location) {
        File directory = new File(location);
        Collection<File> files = FileUtils.listFiles(directory, new String[]{"asp"}, true);

        for(File file: files) {
            try {
                List<String> contents;
                try {
                    contents = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
                } catch (MalformedInputException ex) {
                    contents = Files.readAllLines(file.toPath(), StandardCharsets.ISO_8859_1);
                }
                Asp page = findPage(file.getPath());
                if(page!=null) {
                    createInheritedPageRepresentation(contents, file, page);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void createInheritedPageRepresentation(final List<String> contents, final File file,  final Asp currentPageRepesentation){
        for (String content : contents) {
            Pattern p = Pattern.compile("<!--#include file=\"(.*)\"-->");
            Matcher m = p.matcher(content);
            if (m.find()) {
                String filename = getCanonicalPagePath(file,m.group(1));
                Asp inheritedPage = findPage(filename);
                currentPageRepesentation.inherits.add(inheritedPage);
                pageRepository.createOrUpdate(currentPageRepesentation);
            }
        }
    }

    private String getCanonicalPagePath(final File currentPage, final String includedPageName) {
        File file = new File(currentPage.getPath()+"\\"+includedPageName);
        try {
            return file.getCanonicalPath();
        } catch (IOException e) {
            LOGGER.error(UNABLE_TO_PARSE_FILE);
            return StringUtils.EMPTY;
        }
    }

    private Asp findPage(final String pageName) {
        Asp page = (Asp) pageRepository.find(pageName);
        if(page == null) {
            page = createPage(pageName);
        }
        return page;
    }

    private Asp createPage(final String pagename) {
            return (Asp) pageRepository.createOrUpdate(new Asp(pagename));
    }
}
