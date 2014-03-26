/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sarhan.jpms.objects;

import org.sarhan.jpms.api_types.T1;
import org.sarhan.jpms.api_types.T2;
import org.sarhan.jpms.api_types.T4;
import org.sarhan.jpms.api_types.T5;
import org.sarhan.jpms.api_types.T6;

/**
 *
 * @author alaa
 */
public class O4 extends T4 implements T1, T2, T5, T6{
    @Override
    public String toString() {
        return "O4";
    }
}
