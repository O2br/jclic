/*
 * File    : ActiveBagContentRelPanel.java
 * Created : 03-apr-2003 12:54
 * By      : fbusquets
 *
 * JClic - Authoring and playing system for educational activities
 *
 * Copyright (C) 2000 - 2005 Francesc Busquets & Departament
 * d'Educacio de la Generalitat de Catalunya
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details (see the LICENSE file).
 */

package edu.xtec.jclic.boxes;

import edu.xtec.jclic.Activity;
import edu.xtec.jclic.activities.associations.ComplexAssociation;
import edu.xtec.jclic.activities.text.WrittenAnswer;
import edu.xtec.util.Options;
import java.util.EventObject;

/**
 *
 * @author Francesc Busquets (fbusquets@xtec.cat)
 * @version 13.09.09
 */
public class ActiveBagContentRelPanel extends edu.xtec.util.CtrlPanel {
    
    ActiveBagContentEditor parent=null;
    Options options=null;
    boolean isBoolean=false;
    
    /** Creates new form ActiveBagContentRelPanel */
    public ActiveBagContentRelPanel(ActiveBagContentEditor parent, boolean isBoolean) {
        setInitializing(true);
        this.parent=parent;
        options=parent.getOptions();
        this.isBoolean=isBoolean;
        initComponents();
        if(isBoolean){
            showAllArrowsChk.setVisible(false);
            arrowColorBtn.setVisible(false);
            arrowColorLb.setVisible(false);
        }
        setInitializing(false);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    private void initComponents() {//GEN-BEGIN:initComponents
        java.awt.GridBagConstraints gridBagConstraints;

        layoutGroup = new javax.swing.ButtonGroup();
        showAllArrowsChk = new javax.swing.JCheckBox();
        showAllArrowsChk.addActionListener(this);
        arrowColorLb = new javax.swing.JLabel();
        arrowColorBtn = new edu.xtec.jclic.beans.ColorButton();
        arrowColorBtn.addActionListener(this);
        inverseResolutionChk = new javax.swing.JCheckBox();
        inverseResolutionChk.addActionListener(this);

        setLayout(new java.awt.GridBagLayout());

        showAllArrowsChk.setSelected(true);
        showAllArrowsChk.setText(options.getMsg("edit_act_showAllArrows"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        add(showAllArrowsChk, gridBagConstraints);

        arrowColorLb.setLabelFor(arrowColorBtn);
        arrowColorLb.setText(options.getMsg("edit_act_arrowColor"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        add(arrowColorLb, gridBagConstraints);

        arrowColorBtn.setToolTipText(options.getMsg("edit_act_arrowColor_tooltip"));
        arrowColorBtn.setColor(BoxConnector.getXORColor(BoxConnector.DEFAULT_XOR_COLOR));
        arrowColorBtn.setOptions(options);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        add(arrowColorBtn, gridBagConstraints);

        inverseResolutionChk.setToolTipText(options.getMsg("edit_act_inverseResolution_tooltip"));
        inverseResolutionChk.setText(options.getMsg("edit_act_inverseResolution"));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(2, 2, 2, 2);
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        add(inverseResolutionChk, gridBagConstraints);

    }//GEN-END:initComponents

    
    @Override
    public boolean eventPerformed(EventObject ev){
        boolean result=true;
        if(ev!=null && ev.getSource()!=null){
            Object src=ev.getSource();
            if(src==showAllArrowsChk){
                parent.abcpp.setShowAllArrows(showAllArrowsChk.isSelected());
                result=false;
            }
            else if(src==arrowColorBtn){
                parent.abcpp.arrowColor=BoxConnector.getXORColor(arrowColorBtn.getColor());
                parent.abcpp.repaint();
                result=false;
            }
            else if(src==inverseResolutionChk){
                //parent.setModified(true);
            }
        }
        return result;
    }
    
    
    public void clear() {        
        inverseResolutionChk.setSelected(false);
    }
    
    public void fillData(Activity act){
        if(act!=null){
            inverseResolutionChk.setSelected(act.invAss);
            inverseResolutionChk.setVisible(act instanceof ComplexAssociation
            || act instanceof WrittenAnswer);            
        }
    }
    
    public void saveData(Activity act){
        if(act!=null){
            act.invAss=inverseResolutionChk.isSelected();
        }
    }
        
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private edu.xtec.jclic.beans.ColorButton arrowColorBtn;
    private javax.swing.JLabel arrowColorLb;
    private javax.swing.JCheckBox inverseResolutionChk;
    private javax.swing.ButtonGroup layoutGroup;
    private javax.swing.JCheckBox showAllArrowsChk;
    // End of variables declaration//GEN-END:variables
    
}