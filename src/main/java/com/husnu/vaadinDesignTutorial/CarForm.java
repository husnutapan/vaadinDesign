package com.husnu.vaadinDesignTutorial;

import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.NativeSelect;
import com.vaadin.ui.TextField;
import com.vaadin.ui.themes.ValoTheme;

public class CarForm extends FormLayout {
	private TextField name = new TextField("Name");
	private TextField company = new TextField("Company");
	private NativeSelect carType = new NativeSelect("CarType");
	private TextField cost = new TextField("Cost");

	private Button save = new Button("Save");
	private Button delete = new Button("Delete");

	private CarService service = new CarService();
	private Car car;
	private MyUI myUI;

	public CarForm(MyUI myUI) {
		this.myUI = myUI;
		setSizeUndefined();
		carType.addItems(CarTypes.values());
		save.setStyleName(ValoTheme.BUTTON_PRIMARY);
		save.setClickShortcut(KeyCode.ENTER);
		
		
		save.addClickListener(e->save());
		delete.addClickListener(e->delete());
		
		HorizontalLayout buttons = new HorizontalLayout(save, delete);
		buttons.setSpacing(true);
		addComponents(name, company, carType, cost, buttons);
	}

	public void setCar(Car car) {
		this.car = car;
		BeanFieldGroup.bindFieldsUnbuffered(car, this);
		setVisible(true);
	}

	private void save() {
		service.saveCar(car);
		MyUI myUI = new MyUI();
		setVisible(false);
	}

	private void delete() {
		service.deleteCar(car);
		MyUI myUI = new MyUI();
		setVisible(false);
	}

}
