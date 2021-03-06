package cm.homeautomation.hap;

import java.util.Collection;
import java.util.concurrent.CompletableFuture;

import com.beowulfe.hap.HomekitCharacteristicChangeCallback;
import com.beowulfe.hap.Service;
import com.beowulfe.hap.accessories.HumiditySensor;

public class HAPHumiditySensor implements HumiditySensor {
	private HomekitCharacteristicChangeCallback subscribeCallback = null;
	private String label;
	private Long id;
	private Double humidity;
	private HomekitCharacteristicChangeCallback callback;

	public HAPHumiditySensor(String name, Long id) {

		label = name;
		this.id = id;
	}

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return id.intValue()+200;
	}

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return label;
	}

	@Override
	public void identify() {
		System.out.println("Identifying Humidity");

	}

	@Override
	public String getSerialNumber() {
		// TODO Auto-generated method stub
		return "none";
	}

	@Override
	public String getModel() {
		// TODO Auto-generated method stub
		return "none";
	}

	@Override
	public String getManufacturer() {
		// TODO Auto-generated method stub
		return "none";
	}

	
	/**
	 * @return the subscribeCallback
	 */
	public HomekitCharacteristicChangeCallback getSubscribeCallback() {
		return subscribeCallback;
	}

	/**
	 * @param subscribeCallback the subscribeCallback to set
	 */
	public void setSubscribeCallback(HomekitCharacteristicChangeCallback subscribeCallback) {
		this.subscribeCallback = subscribeCallback;
	}


	@Override
	public CompletableFuture<Double> getCurrentRelativeHumidity() {
		
		return CompletableFuture.completedFuture(getHumidity());
	}

	@Override
	public void subscribeCurrentRelativeHumidity(HomekitCharacteristicChangeCallback callback) {
		this.callback = callback;
		// TODO Auto-generated method stub
		
	}

	@Override
	public void unsubscribeCurrentRelativeHumidity() {
		// TODO Auto-generated method stub
		this.callback=null;
		
	}

	public Double getHumidity() {
		return humidity;
	}

	public void setHumidity(Double humidity) {
		this.humidity = humidity;
	}
}
