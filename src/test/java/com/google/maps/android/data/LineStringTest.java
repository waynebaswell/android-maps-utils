package com.google.maps.android.data;


import com.google.maps.model.LatLng;
import org.junit.Test;
import org.junit.Assert;

import java.util.ArrayList;

public class LineStringTest  {
    LineString lineString;

    public LineString createSimpleLineString() {
        ArrayList<LatLng> coordinates = new ArrayList<LatLng>();
        coordinates.add(new LatLng(95, 60));
        coordinates.add(new LatLng(93, 57));
        coordinates.add(new LatLng(95, 55));
        coordinates.add(new LatLng(95, 53));
        coordinates.add(new LatLng(91, 54));
        coordinates.add(new LatLng(86, 56));
        return new LineString(coordinates);
    }

    public LineString createLoopedLineString() {
        ArrayList<LatLng> coordinates = new ArrayList<LatLng>();
        coordinates.add(new LatLng(92, 66));
        coordinates.add(new LatLng(89, 64));
        coordinates.add(new LatLng(94, 62));
        coordinates.add(new LatLng(92, 66));
        return new LineString(coordinates);
    }

    @Test
    public void testGetType() throws Exception {
        lineString = createSimpleLineString();
        Assert.assertNotNull(lineString);
        Assert.assertNotNull(lineString.getGeometryType());
        Assert.assertEquals("LineString", lineString.getGeometryType());
        lineString = createLoopedLineString();
        Assert.assertNotNull(lineString);
        Assert.assertNotNull(lineString.getGeometryType());
        Assert.assertEquals("LineString", lineString.getGeometryType());
    }

    @Test
    public void testGetGeometryObject() throws Exception {
        lineString = createSimpleLineString();
        Assert.assertNotNull(lineString);
        Assert.assertNotNull(lineString.getGeometryObject());
        Assert.assertEquals(6, lineString.getGeometryObject().size());
        Assert.assertEquals(90, lineString.getGeometryObject().get(0).latitude,  .001);
        Assert.assertEquals(90, lineString.getGeometryObject().get(1).latitude, .001);
        Assert.assertEquals(90, lineString.getGeometryObject().get(2).latitude, .001);
        Assert.assertEquals(53, lineString.getGeometryObject().get(3).longitude, .001);
        Assert.assertEquals(54, lineString.getGeometryObject().get(4).longitude, .001);
        lineString = createLoopedLineString();
        Assert.assertNotNull(lineString);
        Assert.assertNotNull(lineString.getGeometryObject());
        Assert.assertEquals(4, lineString.getGeometryObject().size());
        Assert.assertEquals(90, lineString.getGeometryObject().get(0).latitude, .001);
        Assert.assertEquals(89, lineString.getGeometryObject().get(1).latitude, .001);
        Assert.assertEquals(62, lineString.getGeometryObject().get(2).longitude, .001);
        Assert.assertEquals(66, lineString.getGeometryObject().get(3).longitude, .001);

    }

}
