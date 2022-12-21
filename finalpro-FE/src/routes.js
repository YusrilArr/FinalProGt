
import DashBoard from "./pages/DashBoard.vue";
import DetailkkPage from "./pages/DetailkkPage.vue";
import TambahkkPage from "./pages/TambahkkPage.vue";
import LoginPage from "./pages/LoginPage.vue";
import ListAnggotaPage from "./pages/ListAnggotaPage.vue";
import RegisterPage from "./pages/RegisterPage.vue";
import DetailAnggotaPage from "./pages/DetailAnggotaPage.vue";

export default[
    {
        path: "/Home",
        component: DashBoard,
    },
    {
        path: "/Detail/:id",
        component: DetailkkPage,
    },
    {
        path: "/Tambah",
        component: TambahkkPage,
    },
    {
        path: "/Detail/:id/list",
        name: "ListPage",
        component: ListAnggotaPage,
    },
    {
        path: "/Register",
        name: "Register",
        component: RegisterPage,

    },
    {
        path: "/Login",
        name: "Login",
        component: LoginPage,
    },
    {
        path: "/Detail/:id/list/detailAnggota/:idAnggota",
        name: "DetailAnggota",
        component: DetailAnggotaPage,
    }
    
]