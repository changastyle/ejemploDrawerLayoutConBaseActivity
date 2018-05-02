package viewdevs.com.ar.x;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class BaseActivity extends AppCompatActivity implements View.OnClickListener{

    public RelativeLayout wrapper;
    private android.support.v4.widget.DrawerLayout drawerLayout;
    private ImageButton btnHamb;
    private TextView txtNombreVentanaVentana;
    private String nombreVentana;
    private Context contexto;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        this.contexto = this;

        // 1 - MATCH UI:
        wrapper = (RelativeLayout) findViewById(R.id.wrapper);
        drawerLayout = (android.support.v4.widget.DrawerLayout) findViewById(R.id.drawerLay);
        btnHamb = (ImageButton) findViewById(R.id.btnHamb); btnHamb.setOnClickListener(this);
        txtNombreVentanaVentana = (TextView) findViewById(R.id.txtNombreVentanaVentana);

        // 2 -POPULAR UI:
        this.nombreVentana = "";
        txtNombreVentanaVentana.setText(nombreVentana);

        // 3 - ASOCIO CADA OPCION DE LA BARRA LATERAL, LE ASOCIO UN ACTION LISTENER PARA QUE TENGA SU ACCION:
        manejarSliderLateral();
    }


    public void manejarSliderLateral()
    {
        // DRAWER LAYOUT OPTIONS (SLIDER):
        NavigationView navigationView = (NavigationView) findViewById(R.id.barraMenu);
        View headerView = navigationView.getHeaderView(0);
//        txtUsuarioLogeado = (TextView) headerView.findViewById(R.id.txtUsuarioLogeado);
//        imgAdmin = (ImageView) headerView.findViewById(R.id.imgAdmin);

        // get menu from navigationView
        Menu menu = navigationView.getMenu();


        // find MenuItem you want to change
        final MenuItem menuIngresar = menu.findItem(R.id.menuIngresar);
        final MenuItem menuSoyNuevo = menu.findItem(R.id.menuSoyNuevo);
//        final MenuItem menuCatalogo = menu.findItem(R.id.menuCatalogo);
//        final MenuItem menuCarrito = menu.findItem(R.id.menuCarrito);
//        final MenuItem menuHistorico = menu.findItem(R.id.menuHistorico);
//        final MenuItem menuVendedor1 = menu.findItem(R.id.menuVendedor1);
//        final MenuItem menuVendedor2 = menu.findItem(R.id.menuVendedor2);
//        final MenuItem menuConfig = menu.findItem(R.id.menuConfig);
//        final MenuItem menuCompartir = menu.findItem(R.id.menuCompartir);
//        final MenuItem menuSalir = menu.findItem(R.id.menuSalir);

        //MUESTRO LOS DIFERENTES MENU SEGUN EL USUARIO:
//        if(MasterController.getUsuarioLogeadoGlobal() != null && MasterController.getUsuarioLogeadoGlobal().getId() != -1)
//        {
//            menuIngresar.setVisible(false);
//            menuSoyNuevo.setVisible(false);
//
//            menuCatalogo.setVisible(true);
//            menuConfig.setVisible(true);
//            menuSalir.setVisible(true);
//
//            String strUsuarioLogeado = MasterController.usuarioLogeadoGlobal.getEmail();
//            txtUsuarioLogeado.setText(String.valueOf(strUsuarioLogeado));
//
//            // EL USUARIO ESTA LOGEADO:
//            if(MasterController.getUsuarioLogeadoGlobal().soyAdmin)
//            {
//                //EL USUARIO ES VENDEDOR:
//                menuCatalogo.setVisible(false);
//                menuCarrito.setVisible(false);
//                menuHistorico.setVisible(false);
//                imgAdmin.setVisibility(View.VISIBLE);
//
//
//                menuVendedor1.setVisible(true);
//                menuVendedor2.setVisible(true);
//            }
//            else
//            {
//                //EL USUARIO ES CLIENTE:
//                menuCatalogo.setVisible(true);
//                menuCarrito.setVisible(true);
//                menuHistorico.setVisible(true);
//                imgAdmin.setVisibility(View.GONE);
//
//
//                menuVendedor1.setVisible(false);
//                menuVendedor2.setVisible(false);
//            }
//        }
//        else
//        {
//            // NO HAY USUARIO LOGEADO:
//            menuIngresar.setVisible(true);
//            menuSoyNuevo.setVisible(true);
//
//
//            menuCatalogo.setVisible(false);
//            menuConfig.setVisible(false);
//            menuCarrito.setVisible(false);
//            menuVendedor1.setVisible(false);
//            menuVendedor2.setVisible(false);
//            menuHistorico.setVisible(false);
//            menuSalir.setVisible(false);
//
//            String strUsuarioLogeado = getResources().getString(R.string.strUsuarioLogeado);
//            txtUsuarioLogeado.setText(String.valueOf(strUsuarioLogeado));
//            imgAdmin.setVisibility(View.GONE);
//        }



        // LISTENER DE CLICK SOBRE MENU:
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener()
        {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item)
            {
                System.out.println("MENU SELECCIONADO: " + item.getTitle() + " - " + item.getItemId());

                Intent intent;

                //INGRESAR
                if(item.getItemId() == menuIngresar.getItemId())
                {
                    intent = new Intent(contexto,MainActivity.class);
                    contexto.startActivity(intent);
                }

                //SOY NUEVO
                if(item.getItemId() == menuSoyNuevo.getItemId())
                {
                    intent = new Intent(contexto,Main2Activity.class);
                    contexto.startActivity(intent);
                }
                finish();

                //CATALOGO
//                if(item.getItemId() == menuCatalogo.getItemId())
//                {
//                    intent = new Intent(contexto,CategoriasAct.class);
//                    contexto.startActivity(intent);
//                }
//
//                // MI CARRITO
//                if(item.getItemId() == menuCarrito.getItemId())
//                {
//                    intent = new Intent(contexto,CarritoAct.class);
//                    contexto.startActivity(intent);
//                }
//
//                // SHARE:
//                if(item.getItemId() == menuCompartir.getItemId())
//                {
//                    MasterController.shareWPP(contexto);
//                }
//
//                // VENTAS REALIZADAS:
//                if(item.getItemId() == menuVendedor1.getItemId())
//                {
//                    intent = new Intent(contexto,VentasRealizadasAct.class);
//                    contexto.startActivity(intent);
//                }
//
//                // VISITANTES:
//                if(item.getItemId() == menuVendedor2.getItemId())
//                {
//                    intent = new Intent(contexto,ContadoresACT.class);
//                    contexto.startActivity(intent);
//                }
//                // MI CUENTA:
//                if(item.getItemId() == menuConfig.getItemId())
//                {
//                    intent = new Intent(contexto,FormularioAltaClienteAct.class);
//                    intent.putExtra("modoEdicion",true);
//                    contexto.startActivity(intent);
//                }
//
//                //SALIR
//                if(item.getItemId() == menuSalir.getItemId())
//                {
//                    System.out.println("Quiere salir ");
//                    MasterController.salir();
//                    cerrarDrawer();
//                    hideBotonGuySiHayUsuarioLogeado();
//                    manejarSliderLateral();
//                }
                return false;
            }
        });
    }
//    public void cerrarDrawer()
//    {
//        drawerLayout.closeDrawer(Gravity.LEFT);
//    }
    public void toggleDrawer()
    {
//        Drawable flechitaPatras = getResources().getDrawable(R.drawable.ic_arrow_back_black_24dp);
//        Drawable hamburgesasMenu = getResources().getDrawable(R.drawable.ic_menu_black_24dp);

        if(drawerLayout != null)
        {
            if (drawerLayout.isDrawerOpen(Gravity.START))
            {
                //btnHamb.setImageDrawable(hamburgesasMenu);
                drawerLayout.closeDrawers();
            }
            else
            {
                //btnHamb.setImageDrawable(flechitaPatras);
                drawerLayout.openDrawer(Gravity.START);
            }
        }
        else
        {
            System.out.println("DRAWER ES NULL");
        }
    }
    public void setNombreVentana (String nombreVentana)
    {
        this.nombreVentana = nombreVentana;
        txtNombreVentanaVentana.setText(nombreVentana);
    }

    @Override
    public void onClick(View presionado)
    {
        if(presionado.getId() == btnHamb.getId())
        {
            toggleDrawer();
        }
    }
}
