package com.robmarano;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class javaJourney {

    private static final Logger LOG = LogManager.getLogger(javaJourney.class);

    public static void main(String[] args) {
        System.out.println("starting javaJourney.main()");
        LOG.debug("javaJourney.main() - begin");

        Runner myThread = new Runner();
        System.out.println(myThread);
        myThread.start();

        LOG.debug("javaJourney.main() - end");
        System.out.println("ending javaJourney.main()");
    }
}
