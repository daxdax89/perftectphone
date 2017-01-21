package com.mycompany.perfectphone;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.OptionGroup;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

/**
 * This UI is the application entry point. A UI may either represent a browser
 * window (or tab) or some part of a html page where a Vaadin application is
 * embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is
 * intended to be overridden to add component to the user interface and
 * initialize non-component functionality.
 */
@Theme("mytheme")
@Title("Perfect Phone")
public class MyUI extends UI {

    Navigator nav;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        nav.addView("kreni", new kreni());
        nav.navigateTo("kreni");
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }

    public static class kreni extends VerticalLayout implements View {

        Navigator nav;

        public kreni() {
            Label title = new Label("Find Your Perfect Smartphone");
            Label welcome = new Label("Welcome to DaX's Perfect Smartphone Finder");
            Button start = new Button("Start");
            start.setIcon(FontAwesome.SIGN_IN);

            start.addStyleName(ValoTheme.BUTTON_PRIMARY);

            Label question1 = new Label("Do you like big screen?");
            OptionGroup answer1 = new OptionGroup();
            Button next = new Button("Continue");

            addComponents(title, question1, answer1, next);

            setComponentAlignment(title, Alignment.TOP_CENTER);

            setComponentAlignment(question1, Alignment.TOP_CENTER);

            setComponentAlignment(answer1, Alignment.TOP_CENTER);

            setComponentAlignment(next, Alignment.TOP_CENTER);

        }

        @Override
        public void enter(ViewChangeListener.ViewChangeEvent event) {
            nav = event.getNavigator();
        }

    }
}
