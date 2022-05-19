package interactions.elements.Pages;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.*;
import java.util.Date;

public class ScreenshotAction extends BasicSetup {

    public static String screenshotName;

//    public ScreenshotAction(WebDriver driver) {
//        super(driver);
//    }
//
    public static void writeInExcel(String ScrenshotName, Integer index) throws IOException {
        // TODO Auto-generated method stub
      //  System.setProperty("org.uncommons.reportng.escape-output","false");
        File scrFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
        Date d = new Date();
        screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";
        FileUtils.copyFile(scrFile,
                new File(  "src/Screenshots/"+ScrenshotName + screenshotName));



        File file = new File("src/Screenshots/Excel.xlsx");
        FileInputStream fis = new FileInputStream(file);

        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheetAt(0);


        InputStream is = new FileInputStream("src/Screenshots/"+ScrenshotName + screenshotName);
        byte[] bytes = IOUtils.toByteArray(is);
        int pictureIdx = workbook.addPicture(bytes, Workbook.PICTURE_TYPE_JPEG);
        is.close();

        CreationHelper helper = workbook.getCreationHelper();

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
        pict.resize(0.050);





        try (OutputStream fileOut = new FileOutputStream(new File(String.valueOf(file)))) {
            workbook.write(fileOut);
        }
        System.out.println(sheet.getSheetName());

        fis.close();
        workbook.close();


    }
}
