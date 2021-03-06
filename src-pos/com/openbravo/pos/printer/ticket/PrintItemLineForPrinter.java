//    Openbravo POS is a point of sales application designed for touch screens.
//    Copyright (C) 2007 Openbravo, S.L.
//    http://sourceforge.net/projects/openbravopos
//
//    This program is free software; you can redistribute it and/or modify
//    it under the terms of the GNU General Public License as published by
//    the Free Software Foundation; either version 2 of the License, or
//    (at your option) any later version.
//
//    This program is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
//    GNU General Public License for more details.
//
//    You should have received a copy of the GNU General Public License
//    along with this program; if not, write to the Free Software
//    Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA

package com.openbravo.pos.printer.ticket;

import java.awt.Font;
import java.awt.Graphics2D;

/**
 *
 * @author jaroslawwozniak
 */
public class PrintItemLineForPrinter extends PrintItemLine {

    /** Creates a new instance of PrinterItemLine */
    public PrintItemLineForPrinter(int itextsize) {
        super(itextsize);
        BASEFONT = new Font("Monospaced", Font.PLAIN, 7);
        FONTHEIGHT = 12;
        FONTWIDTH = 4;
    }

    public void draw(Graphics2D g, int x, int y, int width) {
        //  m_itextsize
        MyPrinterState ps = new MyPrinterState(m_itextsize);
        int left = x;
        for (int i = 0; i < m_atext.size(); i++) {
            StyledText t = m_atext.get(i);
            /*AttributedString text = new AttributedString (t.text);
            text = ps.changeSize(m_itextsize, text);
            text = ps.changeStyle(t.style, text);
             */
            g.setFont(ps.getFont(BASEFONT, t.style));
            g.drawString(t.text, left, y);
            left += FONTWIDTH * t.text.length();
        }
    }
}