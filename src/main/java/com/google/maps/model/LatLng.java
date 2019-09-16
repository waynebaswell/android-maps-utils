package com.google.maps.model;

public class LatLng
{
    public final double latitude;
    public final double longitude;

    public LatLng(double latitude, double longitude)
    {
        if (-180.0D <= longitude && longitude < 180.0D)
        {
            this.longitude = longitude;
        }
        else
        {
            this.longitude = ((longitude - 180.0D) % 360.0D + 360.0D) % 360.0D - 180.0D;
        }

        this.latitude = Math.max(-90.0D, Math.min(90.0D, latitude));
    }

    public final boolean equals(Object other)
    {
        if (this == other)
        {
            return true;
        }
        else if (!(other instanceof LatLng))
        {
            return false;
        }
        else
        {
            LatLng var2 = (LatLng)other;
            return Double.doubleToLongBits(this.latitude) == Double.doubleToLongBits(var2.latitude)
                    && Double.doubleToLongBits(this.longitude) == Double.doubleToLongBits(var2.longitude);
        }
    }

    public final String toString()
    {
        double latitude = this.latitude;
        double longitude = this.longitude;
        return (new StringBuilder(60)).append("lat/lng: (")
                .append(latitude).append(",").append(longitude)
                .append(")").toString();
    }

    public final int hashCode()
    {
        long x = Double.doubleToLongBits(this.latitude);
        int y = 31 + (int)(x ^ x >>> 32);
        x = Double.doubleToLongBits(this.longitude);
        return y * 31 + (int)(x ^ x >>> 32);
    }
}
