/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sarhan.jpms.objects;

import org.sarhan.jpms.api_types.T1;
import org.sarhan.jpms.api_types.T2;
import org.sarhan.jpms.api_types.T3;

/**
 *
 * @author alaa
 */
public class O2 extends T3 implements T1 , T2{
    @Override
    public String toString() {
        return "O2";
    }
}
