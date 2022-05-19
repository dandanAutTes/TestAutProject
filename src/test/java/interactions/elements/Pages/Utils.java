package interactions.elements.Pages;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.poi.ss.usermodel.*;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

public class Utils  extends BasicSetup {

    public static String screenshotName;

    public static String takeScreenshot(String stepName) throws IOException {
        System.setProperty("org.uncommons.reportng.escape-output","false");
        File scrFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        Date d = new Date();
        screenshotName = stepName + d.toString().replace(":", "_").replace(" ", "_") + ".jpg";
        FileUtils.copyFile(scrFile,
                new File(  "target/"+screenshotName));

        return "src/Screenshots/"+screenshotName;
    }

    public static void takeScreenshot1() throws IOException {

        Date d = new Date();
        screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";

        File scrFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(scrFile,
                new File(  ".//target//surefire-reports//html//"+screenshotName));

    }

    private static ObjectMapper objectMapper = new ObjectMapper();

    public static String loadFile(String fileName) {

        StringBuilder contentBuilder = new StringBuilder();
        try (Stream<String> stream = Files.lines(Paths.get(fileName), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s).append("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contentBuilder.toString();
    }


    public static <T> List<T> loadStructureListFromFile(String fileName, Class<T> clazz) {
        String content = Utils.loadFile(fileName);
        List<T> list = null;
        try {
            JavaType itemType = Utils.objectMapper.getTypeFactory().constructCollectionType(List.class, clazz);

            list = Utils.objectMapper.readValue(content, itemType);
        } catch (IOException e) {
            e.printStackTrace();

        }
        return list;
    }

    public static void writeToStep(String scName, Integer shIndex, Integer index) throws IOException {

       File file = new File("src/Screenshots/Excel.xlsx");
        FileInputStream fis = new FileInputStream(file);
        Workbook wb = WorkbookFactory.create(fis);

        Sheet sheet = wb.getSheetAt(shIndex);
        InputStream is = new FileInputStream("src/Screenshots/"+scName+".jpg");
        byte[] bytes = IOUtils.toByteArray(is);
        int pictureIdx = wb.addPicture(bytes, Workbook.PICTURE_TYPE_JPEG);
        is.close();

        CreationHelper helper = wb.getCreationHelper();

        // Create the drawing patriarch. This is the top level container for all shapes.
        Drawing<?> drawing = sheet.createDrawingPatriarch();

        // add a picture shape
        ClientAnchor anchor = helper.createClientAnchor();

        // set top-left corner of the picture,
        // subsequent call of Picture#resize() will operate relative to it
        anchor.setCol1(3);
        anchor.setRow1(index);
        Picture pict = drawing.createPicture(anchor, pictureIdx);

        // auto-size picture relative to its top-left corner
        pict.resize(0.4);




        try (OutputStream fileOut = new FileOutputStream(new File(String.valueOf("src/Screenshots/Excel.xlsx")))) {
            wb.write(fileOut);
        }



        fis.close();
        wb.close();


    }

}
