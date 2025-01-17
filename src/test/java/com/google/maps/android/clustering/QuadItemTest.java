/*
 * Copyright 2015 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.maps.android.clustering;

import com.google.maps.model.LatLng;
import com.google.maps.android.clustering.algo.NonHierarchicalDistanceBasedAlgorithm;

import com.google.maps.model.LatLng;
import org.junit.Test;
import org.junit.Assert;

public class QuadItemTest {

    public class TestingItem implements ClusterItem {
        private final LatLng mPosition;

        public TestingItem(double lat, double lng) {
            mPosition = new LatLng(lat, lng);
        }

        @Override
        public LatLng getPosition() {
            return mPosition;
        }

        @Override
        public String getTitle() {
            return null;
        }

        @Override
        public String getSnippet() {
            return null;
        }
    }

    public void setUp() {
        // nothing to setup
    }

    @Test
    public void testRemoval() {
        TestingItem item_1_5 = new TestingItem(0.1, 0.5);
        TestingItem item_2_3 = new TestingItem(0.2, 0.3);

        NonHierarchicalDistanceBasedAlgorithm<ClusterItem> algo
                = new NonHierarchicalDistanceBasedAlgorithm<ClusterItem>();
        algo.addItem(item_1_5);
        algo.addItem(item_2_3);

        Assert.assertEquals(2, algo.getItems().size());

        algo.removeItem(item_1_5);

        Assert.assertEquals(1, algo.getItems().size());

        Assert.assertFalse(algo.getItems().contains(item_1_5));
        Assert.assertTrue(algo.getItems().contains(item_2_3));
    }
}
