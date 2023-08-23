package com.demoDomain.teamcity.demoPlugin.controllers;

import jetbrains.buildServer.web.openapi.PagePlaces;
import jetbrains.buildServer.web.openapi.PlaceId;
import jetbrains.buildServer.web.openapi.PluginDescriptor;
import jetbrains.buildServer.web.openapi.SimpleCustomTab;
import org.jetbrains.annotations.NotNull;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;


public class SakuraUIBTPluginPage extends SimpleCustomTab {
    public SakuraUIBTPluginPage(@NotNull PagePlaces pagePlaces,
                                @NotNull PluginDescriptor descriptor) {
        super(pagePlaces,
                new PlaceId("SAKURA_BUILD_CONF@TAB"),
                Constants.TAB_ID,
                Constants.INCLUDE_URL,
                Constants.TAB_TITLE);

        register();
        addJsFile(descriptor.getPluginResourcesPath("js/main.js"));
        addCssFile(descriptor.getPluginResourcesPath("css/styles.css"));
    }

    @Override
    public void fillModel(@NotNull Map<String, Object> model, @NotNull HttpServletRequest request) {
        model.put("myKey", "Sakura tab");
        super.fillModel(model, request);
    }

    @Override
    public boolean isAvailable(@NotNull HttpServletRequest request) {
        return true;
    }
}
