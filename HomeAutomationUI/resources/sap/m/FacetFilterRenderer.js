/*!
 * UI development toolkit for HTML5 (OpenUI5)
 * (c) Copyright 2009-2015 SAP SE or an SAP affiliate company.
 * Licensed under the Apache License, Version 2.0 - see LICENSE.txt.
 */
sap.ui.define(['jquery.sap.global'],function(q){"use strict";var F={};var a={};F.render=function(r,c){switch(c.getType()){case sap.m.FacetFilterType.Simple:F.renderSimpleFlow(r,c);break;case sap.m.FacetFilterType.Light:F.renderSummaryBar(r,c);break;}};F.renderSimpleFlow=function(r,c){r.write("<div");r.writeControlData(c);r.addClass("sapMFF");if(c.getShowSummaryBar()){r.write(">");F.renderSummaryBar(r,c);}else{if(c._lastScrolling){r.addClass("sapMFFScrolling");}else{r.addClass("sapMFFNoScrolling");}if(c.getShowReset()){r.addClass("sapMFFResetSpacer");}r.writeClasses();r.write(">");if(sap.ui.Device.system.desktop){r.renderControl(c._getScrollingArrow("left"));}r.write("<div");r.writeAttribute("id",c.getId()+"-head");r.addClass("sapMFFHead");r.writeClasses();r.write(">");var l=c._getSequencedLists();for(var i=0;i<l.length;i++){var b=c._getButtonForList(l[i]);if(c.getShowPersonalization()){if(!b.getAriaDescribedBy()||b.getAriaDescribedBy()==''){b.addAriaDescribedBy(this.getAriaAnnouncement("ARIA_REMOVE"));}}r.renderControl(b);if(c.getShowPersonalization()){r.renderControl(c._getFacetRemoveIcon(l[i]));}}if(c.getShowPersonalization()){r.renderControl(c.getAggregation("addFacetButton"));}r.write("</div>");if(sap.ui.Device.system.desktop){r.renderControl(c._getScrollingArrow("right"));}if(c.getShowReset()){r.write("<div");r.addClass("sapMFFResetDiv");r.writeClasses();r.write(">");r.renderControl(c.getAggregation("resetButton"));r.write("</div>");}}r.write("</div>");};F.renderSummaryBar=function(r,c){r.write("<div");r.writeControlData(c);r.addClass("sapMFF");r.writeClasses();r.write(">");var s=c.getAggregation("summaryBar");r.renderControl(s);r.write("</div>");};F.getAriaAnnouncement=function(k,b){if(a[k]){return a[k];}b=b||"FACETFILTER_"+k.toUpperCase();a[k]=new sap.ui.core.InvisibleText({text:sap.ui.getCore().getLibraryResourceBundle("sap.m").getText(b)}).toStatic().getId();return a[k];};F.getAriaDescribedBy=function(c){var d=[];if(c.getShowPersonalization()){d.push(this.getAriaAnnouncement("ARIA_REMOVE"));}return d.join(" ");};F.getAccessibilityState=function(c){return{describedby:{value:this.getAriaDescribedBy(c),append:true}};};return F;},true);