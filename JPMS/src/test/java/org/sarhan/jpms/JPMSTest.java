package org.sarhan.jpms;

import org.sarhan.jpms.objects.O1;
import org.sarhan.jpms.objects.O2;
import org.sarhan.jpms.objects.O3;
import org.sarhan.jpms.objects.O4;
import org.sarhan.jpms.objects.O5;
import org.sarhan.jpms.objects.O6;
import org.sarhan.jpms.objects.O7;
import org.sarhan.jpms.objects.O8;
import org.sarhan.jpms.plugins.P1;
import org.sarhan.jpms.plugins.P2;
import org.sarhan.jpms.plugins.P5;
import org.sarhan.jpms.plugins.P7;
import org.sarhan.jpms.plugins.P8;
import org.sarhan.jpms.plugins.P9;
import java.util.List;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author alaa
 */
@Test
public class JPMSTest {

    public JPMSTest() {
    }
    PluginManager pm;

    @BeforeClass
    public void setUp() {
        pm = new PluginManager(new TestPFLoader());
    }

    @Test
    public void testGetPluginsWithNoObjects() {

        List<Plugin> plugins = pm.getPlugins(P1.class);

        assert plugins.size() == 1 : "Returned plugins count is not correct";

        assert plugins.get(0) instanceof P1 : "Returned plugin type is not correct";
    }

    @Test
    public void testGetPluginsOfPluginForO1() {

        List<Plugin> plugins =
                pm.getPlugins(Plugin.class, new O1());

        assert plugins.size() == 2 : "Returned plugins count is not correct";

        boolean typesCorrect = true;

        if (!(plugins.get(0) instanceof P1
                || plugins.get(0) instanceof P2)) {
            typesCorrect = false;
        }

        if (!(plugins.get(1) instanceof P1
                || plugins.get(1) instanceof P2)) {
            typesCorrect = false;
        }

        assert typesCorrect == true : "Plugin types are not correct";
    }

    @Test
    public void testGetPluginsOfP1ForO1() {
        List<Plugin> plugins =
                pm.getPlugins(P1.class, new O1());

        assert plugins.size() == 1 : "Returned plugins count is not correct";

        assert plugins.get(0) instanceof P1 : "Returned plugin type is not"
                + " correct";
    }

    @Test
    public void testGetPluginsOfP1ForO2() {
        List<Plugin> plugins =
                pm.getPlugins(P1.class, new O2());

        assert plugins.size() == 1 : "Returned plugins count is not correct";

        assert plugins.get(0) instanceof P1 : "Wrong plugin type";
    }

    @Test
    public void testGetPluginsOfP1ForO4() {
        List<Plugin> plugins =
                pm.getPlugins(P1.class, new O4());

        assert plugins.size() == 1 : "Returned plugins count is not correct";

        assert plugins.get(0) instanceof P1 : "Wrong plugin type";
    }

    @Test
    public void testGetPluginsOfP1ForO1O4() {
        List<Plugin> plugins =
                pm.getPlugins(P1.class, new O1(), new O4());

        assert plugins.size() == 1 : "Returned plugins count is not correct";

        assert plugins.get(0) instanceof P1 : "Wrong plugin type";
    }

    @Test
    public void testGetPluginsOfP2() {
        List<Plugin> plugins = pm.getPlugins(P2.class);

        assert plugins.size() == 1 : "Returned plugins count is not correct";

        assert plugins.get(0) instanceof P9 : "Wrong plugin type";
    }

    @Test
    public void testGetPluginsOfP2ForO3O2O5() {
        List<Plugin> plugins = pm.getPlugins(P2.class, new O3(), new O2(), new O5());

        assert plugins.size() == 1 : "Returned plugins count is not correct";

        assert plugins.get(0) instanceof P5 : "Wrong plugin type";
    }

    @Test
    public void testGetPluginsOfP7ForO5O7O8() {
        List<Plugin> plugins = pm.getPlugins(P7.class, new O5(), new O7(), new O8());

        assert plugins.size() == 1 : "Returned plugins count is not correct";

        assert plugins.get(0) instanceof P8 : "Wrong plugin type";
    }

    @Test
    public void testGetPluginsOfP7ForO7() {
        List<Plugin> plugins = pm.getPlugins(P7.class, new O7());

        assert plugins.size() == 1 : "Returned plugins count is not correct";

        assert plugins.get(0) instanceof P7 : "Wrong plugin type";
    }

    @Test
    public void testGetPluginsForO4() {
        List<Plugin> plugins = pm.getPlugins(Plugin.class, new O4());

        assert plugins.size() == 4 : "Returned plugins count is not correct";
    }

    @Test
    public void testGetPluginsForO5() {
        List<Plugin> plugins = pm.getPlugins(Plugin.class, new O5());

        assert plugins.size() == 2 : "Returned plugins count is not correct";
    }

    @Test
    public void testGetPluginsForO6() {
        List<Plugin> plugins = pm.getPlugins(Plugin.class, new O5());

        assert plugins.size() == 2 : "Returned plugins count is not correct";
    }

    @Test
    public void testGetPluginsOfP8ForO5O7() {
        List<Plugin> plugins = pm.getPlugins(P8.class, new O5(), new O7());

        assert plugins.size() == 1 : "Returned plugins count is not correct";
    }

    @Test
    public void testGetPluginsUltimate() {
        List<Plugin> plugins = pm.getPlugins(P8.class, new O1(), new O2(),
                new O3(), new O4(), new O5(), new O6(), new O7(), new O8());
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}