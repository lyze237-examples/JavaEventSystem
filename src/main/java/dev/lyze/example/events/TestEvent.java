package dev.lyze.example.events;

import dev.lyze.eventsystem.events.Event;

public class TestEvent extends Event
{
    private String coolString;

    public TestEvent(String coolString)
    {
        this.coolString = coolString;
    }

    public void setCoolString(String coolString)
    {
        this.coolString = coolString;
    }

    public String getCoolString()
    {
        return coolString;
    }
}
