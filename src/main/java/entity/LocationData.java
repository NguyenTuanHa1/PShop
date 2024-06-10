package entity;

import java.util.List;

public class LocationData {
    private List<Province> province;
    private List<District> district;

    // Getters và setters
    public List<Province> getProvince() {
        return province;
    }

    public void setProvince(List<Province> province) {
        this.province = province;
    }

    public List<District> getDistrict() {
        return district;
    }

    public void setDistrict(List<District> district) {
        this.district = district;
    }
}

