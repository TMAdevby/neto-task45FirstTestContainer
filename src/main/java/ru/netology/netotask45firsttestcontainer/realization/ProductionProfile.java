package ru.netology.netotask45firsttestcontainer.realization;

import ru.netology.netotask45firsttestcontainer.interf.SystemProfile;

public class ProductionProfile implements SystemProfile {
    @Override
    public String getProfile() {
        return "Current profile is production";
    }
}
