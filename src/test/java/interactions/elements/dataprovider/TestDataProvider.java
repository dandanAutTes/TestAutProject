package interactions.elements.dataprovider;

import interactions.elements.Pages.Utils;
import interactions.elements.data.TestData;
import org.testng.annotations.DataProvider;

import java.util.List;

public class TestDataProvider {

    @DataProvider(name="getData")
    public Object[] getData()
    {

        List<TestData> var = Utils.loadStructureListFromFile("src/main/resources/TestData.json", TestData.class);
        Object[] data = var.toArray();

        return data;

    }

    @DataProvider(name="getData1")
    public Object[] getData1()
    {

        List<TestData> var = Utils.loadStructureListFromFile("src/main/resources/TestData1.json", TestData.class);
        Object[] data = var.toArray();

        return data;

    }


}
