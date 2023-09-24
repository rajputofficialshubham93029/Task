package com.shubham.Task;

public class TimePojo 
{
	public String dateAndTime;
	public int duration;
	public TimePojo(String dateAndTime , int duration)
	{
		this.dateAndTime = dateAndTime;
		this.duration = duration;
	}
	public String getDateAndTime()
	{
		return this.dateAndTime;
	}
	public int duration()
	{
		return this.duration;
	}
	
	public String toString()
	{
		return this.dateAndTime+" "+duration;
	}
}
