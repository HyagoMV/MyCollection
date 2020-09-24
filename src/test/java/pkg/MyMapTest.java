package pkg;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

public class MyMapTest {

    Map<String, String> map;
    String key = "Key Test";
    String value = "Value Test";

    @Before
    public void createMap() {
        map = new MyMap<>();
    }

    @After
    public void deleteMap() {
        map = null;
    }

    // --------------------------------

    @Test(expected = NullPointerException.class)
    public void testPut_NullKey() {
        map.put(null, value);
    }

    @Test(expected = NullPointerException.class)
    public void testPut_NullValue() {
        map.put(key, null);
    }

    @Test(expected = ClassCastException .class)
    public void testPut_WrongTypeKey() {
        Object wrongTypeKey = new Object();
        map.put((String) wrongTypeKey, value);
    }

    @Test(expected = ClassCastException .class)
    public void testPut_WrongTypeValue() {
        Object wrongTypeValue = new Object();
        map.put(key, (String) wrongTypeValue);
    }

    // --------------------------------

    @Test
    public void testPut_ReturnNullValue() {
       Assert.assertNull(map.put(key, value));
    }

    @Test
    public void testPut_ReturnOldValue() {
        map.put(key, value);
        Assert.assertEquals(value, map.put(key, "New Value"));
    }

    @Test
    public void testGet_ReturValue() {
        map.put(key, value);
        Assert.assertEquals(value, map.get(key));
    }

    @Test
    public void testContainsKey_CheckStoreValue() {
        map.put(key, value);
        Assert.assertTrue(map.containsKey(key));
    }

}
