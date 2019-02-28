package com.jdev.java;

public class PLanet extends HeavenlyBody {

    public PLanet(String name, double orbitalPeriod) {
        super(name, orbitalPeriod, BodyTypes.PLANET);
    }

    @Override
    public boolean addSatellite(HeavenlyBody moon) {
        if (moon.getKey().getBodyType() == BodyTypes.MOON){
            return super.addSatellite(moon);
        }
        else{
            return false;
        }
    }
}

