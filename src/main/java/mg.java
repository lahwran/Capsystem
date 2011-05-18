// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) fieldsfirst safe
// Source File Name:   SourceFile

import java.io.*;
import java.net.*;
import java.util.Random;

import net.lahwran.mcclient.capsystem.Capsystem;
import net.lahwran.mcclient.capsystem.ChatHook;
import net.lahwran.mcclient.capsystem.ChatProcessor;
import net.minecraft.client.Minecraft;

public class mg extends se {

    private boolean c;
    private og d;
    public String a;
    private Minecraft e;
    private lq f;
    private boolean g;
    Random b;

    public mg(Minecraft minecraft, String s, int i) throws UnknownHostException, IOException {
        c = false;
        g = false;
        b = new Random();
        e = minecraft;
        Socket socket = new Socket(InetAddress.getByName(s), i);
        d = new og(socket, "Client", ((se) (this)));
    }

    public void a() {
        if(c) {
            return;
        } else {
            d.a();
            return;
        }
    }

    public void a(nd nd1) {
        e.b = ((nf) (new wa(e, this)));
        e.G.a(is.i, 1);
        f = new lq(this, nd1.c, ((int) (nd1.d)));
        f.v = true;
        e.a(((et) (f)));
        e.a(((cs) (new fv(this))));
        e.g.aB = nd1.a;

        // TODO: update
        Capsystem._connectedToServer(new Chatsender());
    }

    public void a(mh mh1) {
        double d1 = (double)mh1.b / 32D;
        double d2 = (double)mh1.c / 32D;
        double d3 = (double)mh1.d / 32D;
        gz gz1 = new gz(((et) (f)), d1, d2, d3, new ii(mh1.h, mh1.i, mh1.l));
        gz1.aN = (double)mh1.e / 128D;
        gz1.aO = (double)mh1.f / 128D;
        gz1.aP = (double)mh1.g / 128D;
        gz1.bG = mh1.b;
        gz1.bH = mh1.c;
        gz1.bI = mh1.d;
        f.a(mh1.a, ((rj) (gz1)));
    }

    public void a(rk rk1) {
        double d1 = (double)rk1.b / 32D;
        double d2 = (double)rk1.c / 32D;
        double d3 = (double)rk1.d / 32D;
        rj obj = null;

        if(rk1.e == 10)
            obj = ((rj) (new xb(((et) (f)), d1, d2, d3, 0)));

        if(rk1.e == 11)
            obj = ((rj) (new xb(((et) (f)), d1, d2, d3, 1)));

        if(rk1.e == 12)
            obj = ((rj) (new xb(((et) (f)), d1, d2, d3, 2)));

        if(rk1.e == 90)
            obj = ((rj) (new lb(((et) (f)), d1, d2, d3)));

        if(rk1.e == 60)
            obj = ((rj) (new rh(((et) (f)), d1, d2, d3)));

        if(rk1.e == 61)
            obj = ((rj) (new br(((et) (f)), d1, d2, d3)));

        if(rk1.e == 62)
            obj = ((rj) (new uo(((et) (f)), d1, d2, d3)));

        if(rk1.e == 1)
            obj = ((rj) (new fo(((et) (f)), d1, d2, d3)));

        if(rk1.e == 50)
            obj = ((rj) (new pw(((et) (f)), d1, d2, d3)));

        if(rk1.e == 70)
            obj = ((rj) (new ja(((et) (f)), d1, d2, d3, to.E.bl)));

        if(rk1.e == 71)
            obj = ((rj) (new ja(((et) (f)), d1, d2, d3, to.F.bl)));

        if(obj != null) {
            obj.bG = rk1.b;
            obj.bH = rk1.c;
            obj.bI = rk1.d;
            obj.aQ = 0.0F;
            obj.aR = 0.0F;
            obj.aB = rk1.a;
            f.a(rk1.a, ((rj) (obj)));
        }
    }

    public void a(eq eq1) {
        double d1 = (double)eq1.b / 32D;
        double d2 = (double)eq1.c / 32D;
        double d3 = (double)eq1.d / 32D;
        c c1 = null;

        if(eq1.e == 1)
            c1 = new c(((et) (f)), d1, d2, d3);

        if(c1 != null) {
            c1.bG = eq1.b;
            c1.bH = eq1.c;
            c1.bI = eq1.d;
            c1.aQ = 0.0F;
            c1.aR = 0.0F;
            c1.aB = eq1.a;
            f.a(((rj) (c1)));
        }
    }

    public void a(um um1) {
        pv pv1 = new pv(((et) (f)), um1.b, um1.c, um1.d, um1.e, um1.f);
        f.a(um1.a, ((rj) (pv1)));
    }

    public void a(fy fy1) {
        rj rj1 = a(fy1.a);

        if(rj1 == null) {
            return;
        } else {
            rj1.a((double)fy1.b / 8000D, (double)fy1.c / 8000D, (double)fy1.d / 8000D);
            return;
        }
    }

    public void a(tr tr1) {
        rj rj1 = a(tr1.a);

        if(rj1 != null && tr1.b() != null)
            rj1.ad().a(tr1.b());
    }

    public void a(lm lm1) {
        double d1 = (double)lm1.c / 32D;
        double d2 = (double)lm1.d / 32D;
        double d3 = (double)lm1.e / 32D;
        float f1 = (float)(lm1.f * 360) / 256F;
        float f2 = (float)(lm1.g * 360) / 256F;
        wp wp1 = new wp(e.e, lm1.b);
        wp1.bG = lm1.c;
        wp1.bH = lm1.d;
        wp1.bI = lm1.e;
        int i = lm1.h;

        if(i == 0)
            wp1.f.a[wp1.f.c] = null;
        else
            wp1.f.a[wp1.f.c] = new ii(i, 1, 0);

        wp1.b(d1, d2, d3, f1, f2);
        f.a(lm1.a, ((rj) (wp1)));
    }

    public void a(qg qg1) {
        rj rj1 = a(qg1.a);

        if(rj1 == null) {
            return;
        } else {
            rj1.bG = qg1.b;
            rj1.bH = qg1.c;
            rj1.bI = qg1.d;
            double d1 = (double)rj1.bG / 32D;
            double d2 = (double)rj1.bH / 32D + 0.015625D;
            double d3 = (double)rj1.bI / 32D;
            float f1 = (float)(qg1.e * 360) / 256F;
            float f2 = (float)(qg1.f * 360) / 256F;
            rj1.a(d1, d2, d3, f1, f2, 3);
            return;
        }
    }

    public void a(td td1) {
        rj rj1 = a(td1.a);

        if(rj1 == null) {
            return;
        } else {
            rj1.bG += ((int) (td1.b));
            rj1.bH += ((int) (td1.c));
            rj1.bI += ((int) (td1.d));
            double d1 = (double)rj1.bG / 32D;
            double d2 = (double)rj1.bH / 32D + 0.015625D;
            double d3 = (double)rj1.bI / 32D;
            float f1 = td1.g ? (float)(td1.e * 360) / 256F : rj1.aQ;
            float f2 = td1.g ? (float)(td1.f * 360) / 256F : rj1.aR;
            rj1.a(d1, d2, d3, f1, f2, 3);
            return;
        }
    }

    public void a(qt qt1) {
        f.c(qt1.a);
    }

    public void a(hr hr1) {
        cu cu1 = e.g;
        double d1 = ((gh) (cu1)).aK;
        double d2 = ((gh) (cu1)).aL;
        double d3 = ((gh) (cu1)).aM;
        float f1 = ((gh) (cu1)).aQ;
        float f2 = ((gh) (cu1)).aR;

        if(hr1.h) {
            d1 = hr1.a;
            d2 = hr1.b;
            d3 = hr1.c;
        }

        if(hr1.i) {
            f1 = hr1.e;
            f2 = hr1.f;
        }

        cu1.bm = 0.0F;
        cu1.aN = cu1.aO = cu1.aP = 0.0D;
        ((gh) (cu1)).b(d1, d2, d3, f1, f2);
        hr1.a = ((gh) (cu1)).aK;
        hr1.b = ((gh) (cu1)).aU.b;
        hr1.c = ((gh) (cu1)).aM;
        hr1.d = ((gh) (cu1)).aL;
        d.a(((jo) (hr1)));

        if(!g) {
            e.g.aH = e.g.aK;
            e.g.aI = e.g.aL;
            e.g.aJ = e.g.aM;
            g = true;
            e.a(((cs) (null)));
        }
    }

    public void a(rb rb1) {
        f.a(rb1.a, rb1.b, rb1.c);
    }

    public void a(vl vl1) {
        kq kq1 = f.c(vl1.a, vl1.b);
        int i = vl1.a * 16;
        int j = vl1.b * 16;

        for(int k = 0; k < vl1.f; k++) {
            short word0 = vl1.c[k];
            int l = vl1.d[k] & 0xff;
            byte byte0 = vl1.e[k];
            int i1 = word0 >> 12 & 0xf;
            int j1 = word0 >> 8 & 0xf;
            int k1 = word0 & 0xff;
            kq1.a(i1, k1, j1, l, ((int) (byte0)));
            f.c(i1 + i, k1, j1 + j, i1 + i, k1, j1 + j);
            f.b(i1 + i, k1, j1 + j, i1 + i, k1, j1 + j);
        }
    }

    public void a(dw dw1) {
        f.c(dw1.a, dw1.b, dw1.c, (dw1.a + dw1.d) - 1, (dw1.b + dw1.e) - 1, (dw1.c + dw1.f) - 1);
        f.a(dw1.a, dw1.b, dw1.c, dw1.d, dw1.e, dw1.f, dw1.g);
    }

    public void a(sr sr1) {
        f.e(sr1.a, sr1.b, sr1.c, sr1.d, sr1.e);
    }

    public void a(xh xh1) {
        d.a("disconnect.kicked", new Object[0]);
        Capsystem._disconnected(); //TODO: update
        c = true;
        e.a(((et) (null)));
        e.a(((cs) (new en("disconnect.disconnected", "disconnect.genericReason", new Object[] {
                              xh1.a
                          }))));
    }

    public void a(String s, Object aobj[]) {
        if(c) {
            return;
        } else {
            c = true;
            e.a(((et) (null)));
            e.a(((cs) (new en("disconnect.lost", s, aobj))));
            Capsystem._disconnected(); //TODO: update
            return;
        }
    }

    public void a(jo jo) {
        if(c) {
            return;
        } else {
            d.a(jo);
            return;
        }
    }

    public void a(da da1) {
        rj rj1 = a(da1.a);
        Object obj = ((Object) ((kw)a(da1.b)));

        if(obj == null)
            obj = ((Object) (e.g));

        if(rj1 != null) {
            f.a(rj1, "random.pop", 0.2F, ((b.nextFloat() - b.nextFloat()) * 0.7F + 1.0F) * 2.0F);
            e.i.a(((wm) (new ec(e.e, rj1, ((rj) (obj)), -0.5F))));
            f.c(da1.a);
        }
    }

    public void a(of of1) {
        //TODO: update
        if(ChatProcessor.processChat(of1.a))
            System.out.println("chatmsg (cap): "+of1.a);
        else if (ChatHook.runhooks(of1.a))
            System.out.println("chatmsg (hook): "+of1.a);
        else
        {
            System.out.println("chatmsg: "+of1.a);
            e.u.a(of1.a);
        }
    }

    public void a(mq mq1) {
        rj rj1 = a(mq1.a);

        if(rj1 == null)
            return;

        if(mq1.b == 1) {
            gh gh1 = (gh)rj1;
            gh1.K();
        } else if(mq1.b == 2)
            rj1.h();
        else if(mq1.b == 3) {
            gh gh2 = (gh)rj1;
            gh2.a(false, false, false);
        } else if(mq1.b == 4) {
            gh gh3 = (gh)rj1;
            gh3.w();
        }
    }

    public void a(jf jf1) {
        rj rj1 = a(jf1.a);

        if(rj1 == null)
            return;

        if(jf1.e == 0) {
            gh gh1 = (gh)rj1;
            gh1.b(jf1.b, jf1.c, jf1.d);
        }
    }

    public void a(lt lt1) {
        if(lt1.a.equals("-"))
            a(((jo) (new nd(e.j.b, 11))));
        else
            try {
                URL url = new URL((new StringBuilder()).append("http://www.minecraft.net/game/joinserver.jsp?user=").append(e.j.b).append("&sessionId=").append(e.j.c).append("&serverId=").append(lt1.a).toString());
                BufferedReader bufferedreader = new BufferedReader(((java.io.Reader) (new InputStreamReader(url.openStream()))));
                String s = bufferedreader.readLine();
                bufferedreader.close();

                if(s.equalsIgnoreCase("ok"))
                    a(((jo) (new nd(e.j.b, 11))));
                else
                {
                    d.a("disconnect.loginFailedInfo", new Object[] {
                            s
                        });
                    Capsystem._disconnected(); //TODO: update
                }
            } catch(Exception exception) {
                exception.printStackTrace();
                Capsystem._disconnected(); //TODO: update
                d.a("disconnect.genericReason", new Object[] {
                        (new StringBuilder()).append("Internal client error: ").append(exception.toString()).toString()
                    });
            }
    }

    public void b() {
        c = true;
        d.a("disconnect.closed", new Object[0]);
        Capsystem._disconnected(); //TODO: update
    }

    public void a(it it1) {
        double d1 = (double)it1.c / 32D;
        double d2 = (double)it1.d / 32D;
        double d3 = (double)it1.e / 32D;
        float f1 = (float)(it1.f * 360) / 256F;
        float f2 = (float)(it1.g * 360) / 256F;
        kw kw1 = (kw)ik.a(((int) (it1.b)), e.e);
        kw1.bG = it1.c;
        kw1.bH = it1.d;
        kw1.bI = it1.e;
        kw1.aB = it1.a;
        kw1.b(d1, d2, d3, f1, f2);
        kw1.T = true;
        f.a(it1.a, ((rj) (kw1)));
        java.util.List list = it1.b();

        if(list != null)
            kw1.ad().a(list);
    }

    public void a(gu gu1) {
        e.e.a(gu1.a);
    }

    public void a(qc qc1) {
        e.g.a(new bk(qc1.a, qc1.b, qc1.c));
    }

    public void a(mw mw1) {
        Object obj = ((Object) (a(mw1.a)));
        rj rj1 = a(mw1.b);

        if(mw1.a == e.g.aB)
            obj = ((Object) (e.g));

        if(obj == null) {
            return;
        } else {
            ((rj) (obj)).i(rj1);
            return;
        }
    }

    public void a(im im1) {
        rj rj1 = a(im1.a);

        if(rj1 != null)
            rj1.a(im1.b);
    }

    private rj a(int i) {
        if(i == e.g.aB)
            return ((rj) (e.g));
        else
            return f.b(i);
    }

    public void a(ek ek1) {
        e.g.b_(ek1.a);
    }

    public void a(ny ny) {
        e.a(true);
    }

    public void a(ql ql1) {
        px px1 = new px(e.e, ((rj) (null)), ql1.a, ql1.b, ql1.c, ql1.d);
        px1.g = ql1.e;
        px1.a(true);
    }

    public void a(ig ig1) {
        if(ig1.b == 0) {
            try{ //TODO: update
            pp pp1 = new pp(ig1.c, ig1.d);
            e.g.a(((la) (pp1)));
            e.g.h.f = ig1.a;
            }catch(Throwable t){
                t.printStackTrace();
                return;
            }
        } else if(ig1.b == 2) {
            rg rg1 = new rg();
            e.g.a(rg1);
            e.g.h.f = ig1.a;
        } else if(ig1.b == 3) {
            at at1 = new at();
            e.g.a(at1);
            e.g.h.f = ig1.a;
        } else if(ig1.b == 1) {
            cu cu1 = e.g;
            e.g.a(hy.b(((gh) (cu1)).aK), hy.b(((gh) (cu1)).aL), hy.b(((gh) (cu1)).aM));
            e.g.h.f = ig1.a;
        }
    }

    public void a(hd hd1) {
        if(hd1.a == -1)
            e.g.f.b(hd1.c);
        else if(hd1.a == 0)
            e.g.g.a(hd1.b, hd1.c);
        else if(hd1.a == e.g.h.f)
            e.g.h.a(hd1.b, hd1.c);
    }

    public void a(nn nn1) {
        Object do1 = null;

        if(nn1.a == 0)
            do1 = e.g.g;
        else if(nn1.a == e.g.h.f)
            do1 = e.g.h;

        try{
            if(do1 != null)
                if(nn1.c) {
                    Class.forName("do").getMethod("a", short.class).invoke(do1, nn1.b);
                } else {
                    Class.forName("do").getMethod("b", short.class).invoke(do1, nn1.b);
                    a(((jo) (new nn(nn1.a, nn1.b, true))));
                }
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
    }

    public void a(jh jh1) {
        if(jh1.a == 0)
            e.g.g.a(jh1.b);
        else if(jh1.a == e.g.h.f)
            e.g.h.a(jh1.b);
    }

    public void a(te te1) {
        if(e.e.h(te1.a, te1.b, te1.c)) {
            nx nx = e.e.b(te1.a, te1.b, te1.c);

            if(nx instanceof xa) {
                xa xa1 = (xa)nx;

                for(int i = 0; i < 4; i++)
                    xa1.a[i] = te1.d[i];

                xa1.y_();
            }
        }
    }

    public void a(mb mb1) {
        b(((jo) (mb1)));

        if(e.g.h != null && e.g.h.f == mb1.a)
            e.g.h.a(mb1.b, mb1.c);
    }

    public void a(r r1) {
        rj rj1 = a(r1.a);

        if(rj1 != null)
            rj1.c(r1.b, r1.c, r1.d);
    }

    public void a(ls ls) {
        e.g.r();
    }

    public void a(up up1) {
        e.e.d(up1.a, up1.b, up1.c, up1.d, up1.e);
    }

    public void a(bt bt1) {
        int i = bt1.b;

        if(i >= 0 && i < bt.a.length && bt.a[i] != null)
            e.g.b(bt.a[i]);

        if(i == 1) {
            f.x().b(true);
            f.h(1.0F);
        } else if(i == 2) {
            f.x().b(false);
            f.h(0.0F);
        }
    }

    public void a(nj nj1) {
        ((sg)e.g).b(is.a(nj1.a), nj1.b);
    }

    public boolean c() {
        return false;
    }
}
