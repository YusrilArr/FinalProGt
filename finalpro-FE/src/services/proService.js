import http from "../http-common.js";

class kartuService{
    create(data){
        return http.post("/kartu/insert_kartu", data)
    }
    getAll(){
        return http.get("/kartu/getAllKartu");
    }
    delete(id){
        return http.delete(`/kartu/delete_kartu/${id}`);
    }
    updateKartu(id, data){
        return http.put(`/kartu/update_kartu/${id}`, data);
    }
    getKK(id) {
        return http.get(`/kartu/getKK/${id}`);
    }
    getAnggotaById(id){
        return http.get(`/anggota/getAnggotaById/${id}`);
    }
    getAnggotaByIdKK(id_kk){
        return http.get(`/anggota/getAnggotaByIdKK/${id_kk}`);
    }
    createAnggota(data){
        return http.post("/anggota/insert_anggota", data);
    }
    deleteAnggota(id){
        return http.delete(`/anggota/delete_anggota/${id}`);
    }
    getAllAnggota(){
        return http.get("/anggota/getAllAnggota");
    }
    updateAnggota(id, data){
        return http.put(`/anggota/update_anggota/${id}`, data)
    }
    createUser(data){
        return http.post("/user/insert_user", data);
    }
    getUser(data){
        return http.post("/user/getUser", data);
    }
}

export default new kartuService();