package com.nsbt.demo.util;

import com.nsbt.demo.soap.ws.ArrayOfstring20;
import com.nsbt.demo.soap.ws.X9996C1Execute;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.time.format.DateTimeFormatter;
import java.util.GregorianCalendar;
import java.util.stream.Collectors;
import java.time.LocalDateTime;
import java.util.stream.Stream;
import java.time.ZoneId;
import java.util.List;


public class Parameter extends X9996C1Execute {

    private static final short S_ZERO = (short) 0;

    private static final double D_ZERO = 0D;

    private static final double D_ONE = 1D;

    private Parameter(Builder builder){
        this.acnco = builder.acnco;
        this.dfecl = builder.dfecl;
        this.dhocl = builder.dhocl;
        this.drqcl = builder.drqcl;
        this.bopco = builder.bopco;
        this.cvart = builder.cvart;
        this.drqus = builder.drqus;
        this.drqws = builder.drqws;
        this.ddpgc = builder.ddpgc;
        this.ddsuc = builder.ddsuc;
        this.ddmod = builder.ddmod;
        this.ddmda = builder.ddmda;
        this.ddpap = builder.ddpap;
        this.ddcta = builder.ddcta;
        this.ddope = builder.ddope;
        this.ddsbo = builder.ddsbo;
        this.ddtop = builder.ddtop;
        this.dcpgc = builder.dcpgc;
        this.dcsuc = builder.dcsuc;
        this.dcmod = builder.dcmod;
        this.dcmda = builder.dcmda;
        this.dcpap = builder.dcpap;
        this.dccta = builder.dccta;
        this.dcope = builder.dcope;
        this.dcsbo = builder.dcsbo;
        this.dctop = builder.dctop;
        this.dimpo = builder.dimpo;
        this.dimp2 = builder.dimp2;
        this.dmdao = builder.dmdao;
        this.dcotz = builder.dcotz;
        this.edatos = builder.edatos;
        this.etdats = builder.etdats;
        this.evalcs = builder.evalcs;
        this.evalls = builder.evalls;
        this.ecantlin = builder.ecantlin;
        this.hashreq = builder.hashreq;
        this.drpgc = builder.drpgc;
        this.drsuc = builder.drsuc;
        this.drmod = builder.drmod;
        this.drtrn = builder.drtrn;
        this.drrel = builder.drrel;
    }

    public static class Builder {

        private short acnco;
        private XMLGregorianCalendar dfecl;
        private String dhocl;
        private String drqcl;
        private short bopco;
        private short cvart;
        private String drqus;
        private String drqws;
        private short ddpgc;
        private short ddsuc;
        private short ddmod;
        private short ddmda;
        private short ddpap;
        private int ddcta;
        private int ddope;
        private short ddsbo;
        private short ddtop;
        private short dcpgc;
        private short dcsuc;
        private short dcmod;
        private short dcmda;
        private short dcpap;
        private int dccta;
        private int dcope;
        private short dcsbo;
        private short dctop;
        private double dimpo;
        private double dimp2;
        private short dmdao;
        private double dcotz;
        private ArrayOfstring20 edatos;
        private ArrayOfstring20 etdats;
        private ArrayOfstring20 evalcs;
        private ArrayOfstring20 evalls;
        private short ecantlin;
        private String hashreq;
        private short drpgc;
        private short drsuc;
        private short drmod;
        private short drtrn;
        private short drrel;

        private Builder(){

        }

        public Builder canal(short acnco) {
            this.acnco = acnco;
            return this;
        }

        public Builder time(LocalDateTime now){
            try {
                GregorianCalendar gregorianCalendar = GregorianCalendar.from(now.atZone(ZoneId.systemDefault()));
                this.dfecl = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);

                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
                this.dhocl = now.format(dtf);
            } catch (Exception e) {
                throw new RuntimeException("Error al convertir LocalDateTime a XMLGregorianCalendar", e);
            }
            return this;
        }

        public Builder nroReq(String drqcl) {
            this.drqcl = drqcl;
            return this;
        }

        public Builder operacion(short bopco) {
            this.bopco = bopco;
            return this;
        }

        public Builder variante(short cvart) {
            this.cvart = cvart;
            return this;
        }

        public Builder drqus(String drqus) {
            this.drqus = drqus;
            return this;
        }

        public Builder ip(String drqws) {
            this.drqws = drqws;
            return this;
        }

        private Builder ddpgc(short ddpgc) {
            this.ddpgc = ddpgc;
            return this;
        }

        private Builder ddsuc(short ddsuc) {
            this.ddsuc = ddsuc;
            return this;
        }

        private Builder ddmod(short ddmod) {
            this.ddmod = ddmod;
            return this;
        }

        private Builder ddmda(short ddmda) {
            this.ddmda = ddmda;
            return this;
        }

        private Builder ddpap(short ddpap) {
            this.ddpap = ddpap;
            return this;
        }

        private Builder ddcta(int ddcta) {
            this.ddcta = ddcta;
            return this;
        }

        private Builder ddope(int ddope) {
            this.ddope = ddope;
            return this;
        }

        private Builder ddsbo(short ddsbo) {
            this.ddsbo = ddsbo;
            return this;
        }

        private Builder ddtop(short ddtop) {
            this.ddtop = ddtop;
            return this;
        }

        private Builder dcpgc(short dcpgc) {
            this.dcpgc = dcpgc;
            return this;
        }

        private Builder dcsuc(short dcsuc) {
            this.dcsuc = dcsuc;
            return this;
        }

        private Builder dcmod(short dcmod) {
            this.dcmod = dcmod;
            return this;
        }

        private Builder dcmda(short dcmda) {
            this.dcmda = dcmda;
            return this;
        }

        private Builder dcpap(short dcpap) {
            this.dcpap = dcpap;
            return this;
        }

        private Builder dccta(int dccta) {
            this.dccta = dccta;
            return this;
        }

        private Builder dcope(int dcope) {
            this.dcope = dcope;
            return this;
        }

        private Builder dcsbo(short dcsbo) {
            this.dcsbo = dcsbo;
            return this;
        }

        private Builder dctop(short dctop) {
            this.dctop = dctop;
            return this;
        }

        private Builder dimpo(double dimpo) {
            this.dimpo = dimpo;
            return this;
        }

        private Builder dimp2(double dimp2) {
            this.dimp2 = dimp2;
            return this;
        }

        private Builder dmdao(short dmdao) {
            this.dmdao = dmdao;
            return this;
        }

        private Builder dcotz(double dcotz) {
            this.dcotz = dcotz;
            return this;
        }

        private Builder edatos(ArrayOfstring20 edatos) {
            this.edatos = edatos;
            return this;
        }

        public Builder setEdatosItem(int index, String element){
            this.edatos.getItem().set(index, element);
            return this;
        }

        private Builder etdats(ArrayOfstring20 etdats) {
            this.etdats = etdats;
            return this;
        }

        public Builder setEtdatsItem(int index, String element){
            this.etdats.getItem().set(index, element);
            return this;
        }

        private Builder evalcs(ArrayOfstring20 evalcs) {
            this.evalcs = evalcs;
            return this;
        }

        public Builder setEvalcsItem(int index, String element){
            this.evalcs.getItem().set(index, element);
            return this;
        }

        private Builder evalls(ArrayOfstring20 evalls) {
            this.evalls = evalls;
            return this;
        }

        public Builder setEvallsItem(int index, String element){
            this.evalls.getItem().set(index, element);
            return this;
        }

        public Builder ecantlin(short ecantlin) {
            this.ecantlin = ecantlin;
            return this;
        }

        public Builder hashreq(String hashreq) {
            this.hashreq = hashreq;
            return this;
        }

        private Builder drpgc(short drpgc) {
            this.drpgc = drpgc;
            return this;
        }

        private Builder drsuc(short drsuc) {
            this.drsuc = drsuc;
            return this;
        }

        private Builder drmod(short drmod) {
            this.drmod = drmod;
            return this;
        }

        private Builder drtrn(short drtrn) {
            this.drtrn = drtrn;
            return this;
        }

        private Builder drrel(short drrel) {
            this.drrel = drrel;
            return this;
        }

        public Parameter build(){
            return new Parameter(this);
        }

    }

    public static Builder builder() {
        return new Builder()
                .ddpgc(S_ZERO).ddsuc(S_ZERO).ddmod(S_ZERO).ddmda(S_ZERO).ddpap(S_ZERO).ddcta(S_ZERO).ddope(S_ZERO).ddsbo(S_ZERO).ddtop(S_ZERO)
                .dcpgc(S_ZERO).dcsuc(S_ZERO).dcmod(S_ZERO).dcmda(S_ZERO).dcpap(S_ZERO).dccta(S_ZERO).dcope(S_ZERO).dcsbo(S_ZERO).dctop(S_ZERO)
                .dimpo(D_ZERO).dimp2(D_ZERO).dmdao(S_ZERO).dcotz(D_ONE).drpgc(S_ZERO).drsuc(S_ZERO).drmod(S_ZERO).drtrn(S_ZERO).drrel(S_ZERO)
                .edatos(getEmptyArray()).etdats(getEmptyArray()).evalcs(getEmptyArray()).evalls(getEmptyArray());
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder builder2 = new StringBuilder();
        builder2.append("Parameter [acnco=");
        builder2.append(acnco);
        builder2.append(", dfecl=");
        builder2.append(dfecl);
        builder2.append(", dhocl=");
        builder2.append(dhocl);
        builder2.append(", drqcl=");
        builder2.append(drqcl);
        builder2.append(", bopco=");
        builder2.append(bopco);
        builder2.append(", cvart=");
        builder2.append(cvart);
        builder2.append(", drqus=");
        builder2.append(drqus);
        builder2.append(", drqws=");
        builder2.append(drqws);
        builder2.append(", ddpgc=");
        builder2.append(ddpgc);
        builder2.append(", ddsuc=");
        builder2.append(ddsuc);
        builder2.append(", ddmod=");
        builder2.append(ddmod);
        builder2.append(", ddmda=");
        builder2.append(ddmda);
        builder2.append(", ddpap=");
        builder2.append(ddpap);
        builder2.append(", ddcta=");
        builder2.append(ddcta);
        builder2.append(", ddope=");
        builder2.append(ddope);
        builder2.append(", ddsbo=");
        builder2.append(ddsbo);
        builder2.append(", ddtop=");
        builder2.append(ddtop);
        builder2.append(", dcpgc=");
        builder2.append(dcpgc);
        builder2.append(", dcsuc=");
        builder2.append(dcsuc);
        builder2.append(", dcmod=");
        builder2.append(dcmod);
        builder2.append(", dcmda=");
        builder2.append(dcmda);
        builder2.append(", dcpap=");
        builder2.append(dcpap);
        builder2.append(", dccta=");
        builder2.append(dccta);
        builder2.append(", dcope=");
        builder2.append(dcope);
        builder2.append(", dcsbo=");
        builder2.append(dcsbo);
        builder2.append(", dctop=");
        builder2.append(dctop);
        builder2.append(", dimpo=");
        builder2.append(dimpo);
        builder2.append(", dimp2=");
        builder2.append(dimp2);
        builder2.append(", dmdao=");
        builder2.append(dmdao);
        builder2.append(", dcotz=");
        builder2.append(dcotz);
        builder2.append(", edatos=");
        builder2.append(edatos);
        builder2.append(", etdats=");
        builder2.append(etdats);
        builder2.append(", evalcs=");
        builder2.append(evalcs);
        builder2.append(", evalls=");
        builder2.append(evalls);
        builder2.append(", ecantlin=");
        builder2.append(ecantlin);
        builder2.append(", hashreq=");
        builder2.append(hashreq);
        builder2.append(", drpgc=");
        builder2.append(drpgc);
        builder2.append(", drsuc=");
        builder2.append(drsuc);
        builder2.append(", drmod=");
        builder2.append(drmod);
        builder2.append(", drtrn=");
        builder2.append(drtrn);
        builder2.append(", drrel=");
        builder2.append(drrel);
        builder2.append("]");
        return builder2.toString();
    }

    private static ArrayOfstring20 getEmptyArray() {
        List<String> lista = Stream
                .of("", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "")
                .collect(Collectors.toList());
        ArrayOfstring20 array = new ArrayOfstring20();
        array.getItem().addAll(lista);
        return array;
    }

}
