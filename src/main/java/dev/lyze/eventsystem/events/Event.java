package dev.lyze.eventsystem.events;

import dev.lyze.eventsystem.data.EventData;

public abstract class Event<TData extends EventData>
{
    private final TData data;

    public Event(TData data)
    {
        this.data = data;
    }

    public TData getData()
    {
        return data;
    }
}
