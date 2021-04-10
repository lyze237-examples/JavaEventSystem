package dev.lyze.example.events;

import dev.lyze.eventsystem.data.EventData;
import dev.lyze.eventsystem.events.Event;

public class TestEvent extends Event<TestEvent.TestEventData>
{
    public TestEvent(TestEventData data)
    {
        super(data);
    }

    public static class TestEventData extends EventData
    {
        private String coolString;

        public TestEventData(String coolString)
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
}
