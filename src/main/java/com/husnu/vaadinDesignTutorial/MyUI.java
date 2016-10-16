package com.husnu.vaadinDesignTutorial;

import java.util.List;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.util.BeanContainer;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {
	
	private CarService carService = new CarService();

	private Grid grid = new Grid();
	
	private TextField filterText = new TextField("Filter by name");
	
	private CarForm form = new CarForm(this);
	
    @Override
    protected void init(VaadinRequest vaadinRequest) {
    	VerticalLayout layout = new VerticalLayout();
    	
    	filterText.addTextChangeListener(e-> {
    		grid.setContainerDataSource(new BeanItemContainer<>(Car.class,carService.getFilterToDataGrid(e.getText())));
    	});
    	
    	
    	Button button = new Button("Clear Filter Area");
    	
    	button.addClickListener(e->{
    		filterText.clear();
    		List<Car> cars = carService.getCars();
        	grid.setContainerDataSource(new BeanItemContainer<>(Car.class,cars));
    	});
    	
    	
    	layout.addComponents(filterText,button,grid);
    	grid.setColumns("id","name","company","cost");
    	
    	
    	HorizontalLayout main = new HorizontalLayout(grid,form);
    	main.setSpacing(true);
    	main.setSizeFull();
    	grid.setSizeFull();
    	main.setExpandRatio(grid, 1);
    	
    	List<Car> cars = carService.getCars();
    	grid.setContainerDataSource(new BeanItemContainer<>(Car.class,cars));
    	layout.setMargin(true);
    	layout.setSpacing(true);
    	layout.addComponents(main);
    	setContent(layout);
    	
    	form.setVisible(false);
    	
    	grid.addSelectionListener(event->{
    		if(event.getSelected().isEmpty()){
    			form.setVisible(false);
    		}
    		else{
    			Car car = (Car) event.getSelected().iterator().next();
    			form.setCar(car);
    		}
    		
    	});
    	
    	
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
