package com.fc.demo1._static;

import org.junit.Test;

public class Court {
    @Test
    public void test() {
        // 原告击鼓鸣冤
        Lawsuit parties = new Parties();

        Lawsuit lawyer = new Lawyer(parties);

        lawyer.submit();
        lawyer.defend();
    }
}
