/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pinkdrive.util;


/**
 *
 * @author aubreymalabie
 */
public class GeoDistance {
    private static final double RADIUS = 6372.7976;
     private static final double COORD_PER_KM = 9500/1E6;

    

     public static Radius getRadius(double latitude,
            double longitude, int radiusKM) {
        Radius rad = new Radius();
        double coordPoints = radiusKM * COORD_PER_KM;

        rad.setNorth(latitude + coordPoints);
        rad.setSouth(latitude - coordPoints);
        rad.setEast(longitude + coordPoints);
        rad.setWest(longitude - coordPoints);
        return rad;
    }
    
    public static double calculateDistance(double sLatitude, double sLongitude,
            double eLatitude, double eLongitude) {
      
      double dLat = Math.toRadians(eLatitude-sLatitude);
      double dLon = Math.toRadians(eLongitude-sLongitude);
      double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
      Math.cos(Math.toRadians(sLatitude)) * Math.cos(Math.toRadians(eLatitude)) *
      Math.sin(dLon/2) * Math.sin(dLon/2);
      double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
      double distance = RADIUS * c;
      return distance;
   }
   
}
