package ru.netology.netotask45firsttestcontainer.realization;

import org.springframework.stereotype.Component;
import ru.netology.netotask45firsttestcontainer.interf.SystemProfile;

public class DevProfile implements SystemProfile {
    @Override
    public String getProfile() {
        return "Current profile is dev";
    }
}
