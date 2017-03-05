package ois.internship;

import org.junit.Test;

import ois.internship.controller.logic.billCalc.FreeMeｍberLogic;

import static junit.framework.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class FreeMeｍberLogicTest {

    @Test
    public void FreeMeｍberLogic_constructor() throws Exception {
        int item1[] = {};
        FreeMeｍberLogic freeMeｍberLogic1 = new FreeMeｍberLogic(item1, 0, 0, false);
        assertEquals(freeMeｍberLogic1.getBillDeliverPrice(), 0);
        assertEquals(freeMeｍberLogic1.getBillDiscountPrice(), 0);
        assertEquals(freeMeｍberLogic1.getBillRemainPoint(), 0);
        assertEquals(freeMeｍberLogic1.getBillTotalPrice(), 0);

        int item2[] = {99};
        FreeMeｍberLogic freeMeｍberLogic2 = new FreeMeｍberLogic(item2, 0, 0, false);
        assertEquals(freeMeｍberLogic2.getBillDeliverPrice(), 350);
        assertEquals(freeMeｍberLogic2.getBillDiscountPrice(), 0);
        assertEquals(freeMeｍberLogic2.getBillRemainPoint(), 1);
        assertEquals(freeMeｍberLogic2.getBillTotalPrice(), 456);
    }

}