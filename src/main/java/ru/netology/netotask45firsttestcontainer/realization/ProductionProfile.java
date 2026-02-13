package ru.netology.netotask45firsttestcontainer.realization;

import ru.netology.netotask42springbootfirst.interf.SystemProfile;

public class ProductionProfile implements SystemProfile {
    @Override
    public String getProfile() {
        return "Current profile is production";
    }
}
