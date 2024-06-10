package service;

import com.fasterxml.jackson.databind.ObjectMapper;
import entity.District;
import entity.LocationData;
import entity.Province;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class CityService {

    public LocationData getVietnamLocations() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        InputStream inputStream = getClass().getResourceAsStream("/city-district.json");
        return mapper.readValue(inputStream, LocationData.class);
    }

    // getDistrictsByProvince
    public List<District> getDistrictsByProvince(String idProvince) throws IOException {
        List<District> list = new ArrayList<>();
        getVietnamLocations().getDistrict().forEach(district -> {
            if (district.getIdProvince().equals(idProvince)) {
                list.add(district);
            }
        });
        return list;
    }
}

