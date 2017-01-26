/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.perfectphone;

import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.FontAwesome;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.OptionGroup;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

/**
 *
 * @author daxdax89
 */
class start extends VerticalLayout implements View {

    Navigator navigator;

    public start() {

        Label title = new Label("Find Your Perfect Smartphone");
        title.setId("title");
        Label welcome = new Label("Welcome to DaX's Perfect Smartphone Finder");
        welcome.setId("welcome");
        Button start = new Button("Start");

        start.setIcon(FontAwesome.SIGN_IN);

        start.addStyleName(ValoTheme.BUTTON_PRIMARY);

        Label question1 = new Label("Do you like big screen?");
        OptionGroup answer1 = new OptionGroup();
        Button next = new Button("Continue");

        addComponents(title, question1, answer1, next);

        setComponentAlignment(question1, Alignment.TOP_CENTER);

        setComponentAlignment(answer1, Alignment.TOP_CENTER);

        setComponentAlignment(next, Alignment.TOP_CENTER);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        navigator = event.getNavigator();
    }
}
