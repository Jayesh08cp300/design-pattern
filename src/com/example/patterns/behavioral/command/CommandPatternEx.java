package com.example.patterns.behavioral.command;

interface Command {
	void execute();
}

class DeviceTurnOn implements Command {

	private Device device;

	DeviceTurnOn(Device device) {
		this.device = device;
	}

	@Override
	public void execute() {
		device.turnOn();
	}
}

class DeviceTurnOff implements Command {

	private Device device;

	DeviceTurnOff(Device device) {
		this.device = device;
	}

	@Override
	public void execute() {
		device.turnOff();
	}
}

class DeviceVolumeAdjust implements Command {

	private Device device;

	DeviceVolumeAdjust(Device device) {
		this.device = device;
	}

	@Override
	public void execute() {
		device.volumeAdjust();
	}
}

class DeviceChannelChange implements Command {

	private Device device;

	DeviceChannelChange(Device device) {
		this.device = device;
	}

	@Override
	public void execute() {
		device.channelChange();
	}
}

interface Device {
	void turnOn();

	void turnOff();

	void volumeAdjust();

	void channelChange();
}

class Tv implements Device {

	@Override
	public void turnOn() {
		System.out.println("Tv is On");
	}

	@Override
	public void turnOff() {
		System.out.println("Tv is Off");
	}

	@Override
	public void volumeAdjust() {
		System.out.println("Tv volume is adjusted");
	}

	@Override
	public void channelChange() {
		System.out.println("Tv channel changed.");
	}
}

public class CommandPatternEx {

	public static void main(String[] args) {
		Device device = new Tv();

		Command command = new DeviceTurnOn(device);
		command.execute();

		command = new DeviceVolumeAdjust(device);
		command.execute();

		command = new DeviceChannelChange(device);
		command.execute();

		command = new DeviceTurnOff(device);
		command.execute();
	}
}
