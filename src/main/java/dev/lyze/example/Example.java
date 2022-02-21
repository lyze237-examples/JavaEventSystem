package dev.lyze.example;

import dev.lyze.eventsystem.EventListener;
import dev.lyze.eventsystem.EventManager;
import dev.lyze.example.events.TestEvent;

public class Example
{
    private final EventManager events = new EventManager();

    public static void main(String[] args)
    {
        new Example().fire();
    }

    public Example()
    {
        registerListeners();
    }

    private void fire()
    {
        events.fire(new TestEvent("Hello!"));
        events.fire(new TestEvent("Owls are cool"));

        /*
        Outputs:
        First listener fired! Hello!
        First listener fired! Owls are cool
        Second listener fired! Owls are cool
         */
    }

    private void registerListeners()
    {
        // This gets called whenever a TestEvent fires before all other listeners fire
        events.addPreListener(new EventListener<>(TestEvent.class)
        {
            @Override
            protected void fire(TestEvent event)
            {
                System.out.println("First listener fired! " + event.getCoolString());
            }
        });

        // This gets called whenever a TestEvent fires but only when the string inside the data is "Owls are cool"
        events.addListener(new EventListener<>(TestEvent.class)
        {
            @Override
            protected void fire(TestEvent event)
            {
                System.out.println("Second listener fired! " + event.getCoolString());
            }

            @Override
            protected boolean shouldFire(TestEvent event)
            {
                return "Owls are cool".equals(event.getCoolString());
            }
        });
    }
}
