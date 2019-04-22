package com.lintcode.problems;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class MiniumSpanningTreeTest {

    private MinimumSpanningTree mst = new MinimumSpanningTree();
    
//    Input:
//        ["Acity","Bcity",1]
//        ["Acity","Ccity",2]
//        ["Bcity","Ccity",3]
//    Output:
//        ["Acity","Bcity",1]
//        ["Acity","Ccity",2]
    @Test
    public void test1() {
        List<Connection> input = new ArrayList<>();
        input.add(new Connection("Acity", "Bcity", 1));
        input.add(new Connection("Acity", "Ccity", 2));
        input.add(new Connection("Bcity", "Ccity", 3));

        List<Connection> expected = new ArrayList<>();
        expected.add(new Connection("Acity", "Bcity", 1));
        expected.add(new Connection("Acity", "Ccity", 2));
        assertEquals(expected, mst.lowestCost(input));
    }

//    Input:
//        ["Acity","Bcity",2]
//        ["Bcity","Dcity",5]
//        ["Acity","Dcity",4]
//        ["Ccity","Ecity",1]
//    Output:
//        []
    @Test
    public void test2() {
        List<Connection> input = new ArrayList<>();
        input.add(new Connection("Acity", "Bcity", 2));
        input.add(new Connection("Bcity", "Dcity", 5));
        input.add(new Connection("Acity", "Dcity", 4));
        input.add(new Connection("Ccity", "Ecity", 1));

        List<Connection> expected = new ArrayList<>();
        assertEquals(expected, mst.lowestCost(input));
    }

    @Test
    public void test3() {
        List<Connection> input = new ArrayList();
        input.add(new Connection("pXZ","McI",41));
        input.add(new Connection("Xxb","XMY",28));
        input.add(new Connection("csf","LpY",57));
        input.add(new Connection("YXt","YXt",97));
        input.add(new Connection("atd","Jqs",22));
        input.add(new Connection("pwL","GLb",4));
        input.add(new Connection("bxp","cqw",18));
        input.add(new Connection("pwL","Jqs",113));
        input.add(new Connection("aLM","MOe",130));
        input.add(new Connection("GIY","rGq",52));
        input.add(new Connection("KYe","YXt",79));
        input.add(new Connection("dpK","YXt",62));
        input.add(new Connection("teu","sYK",74));
        input.add(new Connection("sZY","rLb",81));
        input.add(new Connection("Mfq","srq",16));
        input.add(new Connection("cGK","adK",123));
        input.add(new Connection("rLb","xqr",93));
        input.add(new Connection("wxp","JuX",29));
        input.add(new Connection("csf","Xxb",68));
        input.add(new Connection("XMY","sHw",42));
        input.add(new Connection("McI","YuO",7));
        input.add(new Connection("HGe","dLZ",122));
        input.add(new Connection("Xxb","JuX",16));
        input.add(new Connection("Jqs","sHw",113));
        input.add(new Connection("uGe","bxp",72));
        input.add(new Connection("cqw","GtI",112));
        input.add(new Connection("GIY","seI",23));
        input.add(new Connection("qap","eIw",76));
        input.add(new Connection("MOe","rpK",98));
        input.add(new Connection("KYe","JuX",10));
        input.add(new Connection("XMY","JuX",52));
        input.add(new Connection("brw","GLb",110));
        input.add(new Connection("XMY","xtZ",77));
        input.add(new Connection("wxp","JHX",137));
        input.add(new Connection("rpK","JuO",70));
        input.add(new Connection("adK","XMY",131));
        input.add(new Connection("sZY","JuX",109));
        input.add(new Connection("Jqs","GLb",113));
        input.add(new Connection("GLb","pLM",127));
        input.add(new Connection("cqw","fca",88));
        input.add(new Connection("xqr","XMY",134));
        input.add(new Connection("pwL","Jqs",41));
        input.add(new Connection("seI","Xxb",7));
        input.add(new Connection("fXI","adK",99));
        input.add(new Connection("adK","bxp",79));
        input.add(new Connection("rdf","sYK",41));
        input.add(new Connection("HGe","atK",81));
        input.add(new Connection("csf","xqr",119));
        input.add(new Connection("KbX","dpK",41));
        input.add(new Connection("ufa","HGe",90));
        input.add(new Connection("dpK","KbX",42));
        input.add(new Connection("GIY","atd",67));
        input.add(new Connection("JLX","HLs",81));
        input.add(new Connection("sZY","ufa",14));
        input.add(new Connection("teu","YXt",22));
        input.add(new Connection("Iec","faJ",31));
        input.add(new Connection("xqr","GLb",56));
        input.add(new Connection("dLZ","JLX",95));
        input.add(new Connection("atd","YuO",12));
        input.add(new Connection("rdf","Hsx",30));
        input.add(new Connection("sYK","Lpq",15));
        input.add(new Connection("dLZ","JLX",56));
        input.add(new Connection("sHw","atd",29));
        input.add(new Connection("tYI","rdf",38));
        input.add(new Connection("qap","XMY",74));
        input.add(new Connection("ubd","pLM",82));
        input.add(new Connection("YuO","fXI",110));
        input.add(new Connection("bxp","xtZ",49));
        input.add(new Connection("GLb","sZY",92));
        input.add(new Connection("suI","HMb",123));
        input.add(new Connection("Jqs","JuX",67));
        input.add(new Connection("Lpq","HLs",45));
        input.add(new Connection("atK","atK",57));
        input.add(new Connection("XMY","pwL",24));
        input.add(new Connection("GtI","Jqs",15));
        input.add(new Connection("XMY","suI",132));
        input.add(new Connection("Jqs","GLb",104));
        input.add(new Connection("JLX","wxp",86));
        input.add(new Connection("GtI","GIY",67));
        input.add(new Connection("Mdq","faJ",105));
        input.add(new Connection("JLX","HLs",74));
        input.add(new Connection("qap","sHw",84));
        input.add(new Connection("HMb","atK",2));
        input.add(new Connection("srq","faJ",43));
        input.add(new Connection("pLM","Iec",94));
        input.add(new Connection("LpY","GtI",128));
        input.add(new Connection("Met","Hsx",5));
        input.add(new Connection("rGq","xqr",93));
        input.add(new Connection("HMb","atK",63));
        input.add(new Connection("wxp","LpY",138));
        input.add(new Connection("pwL","tGr",67));
        input.add(new Connection("Jqs","YXt",27));
        input.add(new Connection("cGK","XMY",47));
        input.add(new Connection("uGe","rLb",11));
        input.add(new Connection("atd","csf",97));
        input.add(new Connection("atK","brw",80));
        input.add(new Connection("seI","rLb",4));
        input.add(new Connection("XMY","tGr",121));
        input.add(new Connection("McI","JuX",46));
        input.add(new Connection("MOe","atd",10));
        input.add(new Connection("pLM","JHX",92));
        input.add(new Connection("GLb","rGq",21));
        input.add(new Connection("KYe","suL",12));
        input.add(new Connection("rdf","Met",3));
        input.add(new Connection("JuO","LpY",49));
        input.add(new Connection("rGq","seI",11));
        input.add(new Connection("rLb","adK",117));
        input.add(new Connection("tYI","GtI",39));
        input.add(new Connection("KYe","sHw",117));
        input.add(new Connection("tYI","xrY",135));
        input.add(new Connection("MOe","Mfq",2));
        input.add(new Connection("suL","teu",73));
        input.add(new Connection("rXH","GIY",63));
        input.add(new Connection("wxp","rXH",125));
        input.add(new Connection("rdf","Mfq",125));
        input.add(new Connection("JuO","YXt",117));
        input.add(new Connection("ufa","xqr",100));
        input.add(new Connection("fca","xtZ",51));
        input.add(new Connection("MOe","Mdq",29));
        input.add(new Connection("Lpq","GtI",13));
        input.add(new Connection("adK","rGq",46));
        input.add(new Connection("qap","sZY",23));
        input.add(new Connection("xrY","aLM",16));
        input.add(new Connection("adK","csf",135));
        input.add(new Connection("bxp","HLs",55));
        input.add(new Connection("sZY","suL",91));
        input.add(new Connection("HGe","KbX",41));
        input.add(new Connection("cqw","sZY",87));
        input.add(new Connection("rLb","YuO",39));
        input.add(new Connection("uGe","srq",31));
        input.add(new Connection("YuO","Mfq",140));
        input.add(new Connection("pXZ","eIw",36));
        input.add(new Connection("KbX","HMb",99));
        input.add(new Connection("HLs","aGb",41));
        input.add(new Connection("wxp","teu",33));
        input.add(new Connection("fXI","sYK",46));
        input.add(new Connection("cGK","HGe",91));
        input.add(new Connection("HMb","suI",51));
        input.add(new Connection("JuX","csf",106));
        input.add(new Connection("sHw","Hsx",83));

        List<Connection> expected = new ArrayList<>();
        expected.add(new Connection("HMb","atK",2));
        expected.add(new Connection("MOe","Mfq",2));
        expected.add(new Connection("rdf","Met",3));
        expected.add(new Connection("pwL","GLb",4));
        expected.add(new Connection("seI","rLb",4));
        expected.add(new Connection("Met","Hsx",5));
        expected.add(new Connection("McI","YuO",7));
        expected.add(new Connection("seI","Xxb",7));
        expected.add(new Connection("KYe","JuX",10));
        expected.add(new Connection("MOe","atd",10));
        expected.add(new Connection("rGq","seI",11));
        expected.add(new Connection("uGe","rLb",11));
        expected.add(new Connection("KYe","suL",12));
        expected.add(new Connection("atd","YuO",12));
        expected.add(new Connection("Lpq","GtI",13));
        expected.add(new Connection("sZY","ufa",14));
        expected.add(new Connection("GtI","Jqs",15));
        expected.add(new Connection("sYK","Lpq",15));
        expected.add(new Connection("Mfq","srq",16));
        expected.add(new Connection("Xxb","JuX",16));
        expected.add(new Connection("xrY","aLM",16));
        expected.add(new Connection("bxp","cqw",18));
        expected.add(new Connection("GLb","rGq",21));
        expected.add(new Connection("atd","Jqs",22));
        expected.add(new Connection("teu","YXt",22));
        expected.add(new Connection("GIY","seI",23));
        expected.add(new Connection("qap","sZY",23));
        expected.add(new Connection("XMY","pwL",24));
        expected.add(new Connection("Jqs","YXt",27));
        expected.add(new Connection("MOe","Mdq",29));
        expected.add(new Connection("sHw","atd",29));
        expected.add(new Connection("wxp","JuX",29));
        expected.add(new Connection("Iec","faJ",31));
        expected.add(new Connection("uGe","srq",31));
        expected.add(new Connection("pXZ","eIw",36));
        expected.add(new Connection("tYI","rdf",38));
        expected.add(new Connection("tYI","GtI",39));
        expected.add(new Connection("HGe","KbX",41));
        expected.add(new Connection("HLs","aGb",41));
        expected.add(new Connection("KbX","dpK",41));
        expected.add(new Connection("pXZ","McI",41));
        expected.add(new Connection("srq","faJ",43));
        expected.add(new Connection("Lpq","HLs",45));
        expected.add(new Connection("adK","rGq",46));
        expected.add(new Connection("fXI","sYK",46));
        expected.add(new Connection("cGK","XMY",47));
        expected.add(new Connection("JuO","LpY",49));
        expected.add(new Connection("bxp","xtZ",49));
        expected.add(new Connection("HMb","suI",51));
        expected.add(new Connection("fca","xtZ",51));
        expected.add(new Connection("bxp","HLs",55));
        expected.add(new Connection("dLZ","JLX",56));
        expected.add(new Connection("xqr","GLb",56));
        expected.add(new Connection("csf","LpY",57));
        expected.add(new Connection("dpK","YXt",62));
        expected.add(new Connection("rXH","GIY",63));
        expected.add(new Connection("pwL","tGr",67));
        expected.add(new Connection("csf","Xxb",68));
        expected.add(new Connection("rpK","JuO",70));
        expected.add(new Connection("JLX","HLs",74));
        expected.add(new Connection("qap","XMY",74));
        expected.add(new Connection("atK","brw",80));
        expected.add(new Connection("HGe","atK",81));
        expected.add(new Connection("ubd","pLM",82));
        expected.add(new Connection("pLM","JHX",92));
        expected.add(new Connection("pLM","Iec",94));
        expected.add(new Connection("aLM","MOe",130));

        List<Connection> output = mst.lowestCost(input);
        assertEquals(expected, output);
    }
}
