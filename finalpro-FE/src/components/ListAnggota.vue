.<template>
  <div>
    <div>
    

    <h1 class=" ml-5 mt-3">Data Anggota Keluarga</h1>
    <div class="d-flex row">
        <div>
            <button class="btn btn-primary mt-3 ml-5" @click="$router.back()">Back</button>

        </div>
        <div>
            <button class="btn btn-success mt-3 ml-4 mb-5" type="button" @click.prevent="tambahAnggota()">Tambah Anggota Keluarga</button>
        </div>

    </div>
    <section class="content" v-show="!addAnggota">
        <div class="mt-3 ml-4 mr-3 border border-primary">
        <table class="table table-striped">
            <thead class="table-info">
            <tr>
                <th scope="col">No</th>
                <th scope="col">NIK</th>
                <th scope="col">Nama</th>
                <th scope="col">Jenis Kelamin</th>
                <th scope="col">Kepala Keluarga</th>
                <th scope="col">Action</th>
            </tr>
            </thead>
            <tbody>
                <tr>
                    <td colspan="6" class="text-center" v-if="AnggotaData.length == 0">Tidak ada Data</td>
                </tr>
            <tr  v-for="(item, index) in AnggotaData" :key="index">
                <th scope="row">{{ index + 1 }}</th>
                <td>{{item.nik}}</td>
                <td>{{item.nama}}</td>
                <td>{{item.jenis_kelamin}}</td>
                <td>{{item.kepala_keluarga}}</td>
                <td>
                <router-link
                    :to="{ name: 'DetailAnggota', params:{idAnggota:item.id}}"
                    type="submit"
                    class="btn btn-primary ml-3"
                    >Detail</router-link
                >
                <button
                type="submit"
                class="btn btn-danger ml-3"
                @click.prevent="deleteAnggotaFunc(item.id)"
                >
                Delete
                </button>
                </td>
            </tr>
            </tbody>
        </table>
        </div>
    </section>

    <section class="content" v-show="addAnggota">
                <div class="container-fluid">
                    <form action="" class="border p-5 bg-gradient-white" @submit.prevent="inputAnggota" v-show="!success">
                        <div class="row d-flex justify-content-between">
                            <div class="col-6">
                                <div class="form-group row">
                                    <label for="nik" class="col-md-6 col-sm-2 col-form-label">NIK</label>
                                    <div class="col-md-6 col-sm-10">
                                        <input type="text" class="form-control" id="nik" name="nik"
                                            placeholder="NIK" v-model="AnggotaInput.nik" />
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="nama" class="col-md-6 col-sm-2 col-form-label">Nama</label>
                                    <div class="col-md-6 col-sm-10">
                                        <input name="nama" id="nama" class="form-control" rows="3"
                                            placeholder="Nama Lengkap" v-model="AnggotaInput.nama">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="jenis_kelamin" class="col-md-6 col-sm-2 col-form-label">Jenis Kelamin</label>
                                    <div class="col-md-6 col-sm-10">
                                        <select id="jenis_kelamin" v-model="AnggotaInput.jenis_kelamin" class="form-control" name="jenis_kelamin">
                                            <option disabled selected label="Pilih Jenis Kelamin"></option>
                                            <option id="pria">Pria</option>
                                            <option id="wanita">Wanita</option>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="tempat_lahir" class="col-md-6 col-sm-2 col-form-label">Tempat Lahir</label>
                                    <div class="col-md-6 col-sm-10">
                                        <input type="text" class="form-control" id="tempat_lahir" name="tempat_lahir" placeholder="Tempat Lahir"
                                            v-model="AnggotaInput.tempat_lahir" />
                                    </div>
                                </div>
                            </div>
                            <div class="col-6">
                                <div class="form-group row">
                                    <label for="tanggal_lahir" class="col-md-6 col-sm-2 col-form-label">Tanggal Lahir</label>
                                    <div class="col-md-6 col-sm-10">
                                        <input type="date" class="form-control" id="tanggal_lahir" name="tanggal_lahir"
                                            v-model="AnggotaInput.tanggal_lahir" />
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="agama" class="col-md-6 col-sm-2 col-form-label">Agama</label>
                                    <div class="col-md-6 col-sm-10">
                                        <input type="text" class="form-control" id="agama" name="agama"
                                            placeholder="Agama" v-model="AnggotaInput.agama" />
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="pendidikan" class="col-md-6 col-sm-2 col-form-label">Pendidikan Terakhir</label>
                                    <div class="col-md-6 col-sm-10">
                                        <input type="text" class="form-control" id="pendidikan" name="pendidikan"
                                            placeholder="Pendidikan Terakhir" v-model="AnggotaInput.pendidikan" />
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="kepala_keluarga" class="col-md-6 col-sm-2 col-form-label">Kepala Keluarga</label>
                                    <div class="col-md-6 col-sm-10">
                                        <select id="kepala_keluarga" v-model="AnggotaInput.kepala_keluarga" class="form-control" name="kepala_keluarga" required>
                                            <option disabled selected label="Pilih Status"></option>
                                            <option id="yes">Yes</option>
                                            <option id="no">No</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <button class="btn btn-primary ml-2 mb-3 mt-4" type="submit">
                        {{ buttonValue }}
                        </button>
                    </form>
                    <TambahAnggotaSuccessForm v-show="success"></TambahAnggotaSuccessForm>
                </div>
            </section>

    </div>
  </div>
</template>

<script>
import anggotaService from "../services/proService";
import TambahAnggotaSuccessForm from "../components/TambahAnggotaSuccessForm.vue";
export default {
  name: "HomeComp",
  components:{
    TambahAnggotaSuccessForm,

  },
  data(){
    return{
      kartuData: [],
      AnggotaData: [],
      AnggotaInput: {
        nik: null,
        agama: null,
        nama: null,
        jenis_kelamin: null,
        tempat_lahir: null,
        tanggal_lahir: null,
        pendidikan: null,
        kepala_keluarga: null,
        id_kk: this.$route.params.id,
      },
      success: false,
      addAnggota: false,
      buttonValue: "Submit"
    };
  },

  mounted(){
    this.getAnggotaByIdKK();
  },
    methods: {
        inputAnggota(){
            let data = this.AnggotaInput;
            anggotaService.createAnggota(data)
            .then((response) => {
          console.log(response.data)
          this.success = true;
            })
            .catch((e) =>{
            console.log(e)
        });
        },
    
    tambahAnggota(){
        this.addAnggota = true;
    },
    listAnggota(){
        this.addAnggota = false;
    },
    getAllAnggota(){
        anggotaService.getAllAnggota()
        .then((response) => {
            this.kartuData = response.data;
        })
        .catch((e) => {
            console.log(e)
        })
    },

    deleteAnggotaFunc(id){
        if(confirm(`Apakah yakin ingin menghapus Anggota Keluarga ini ?`)){
            anggotaService.deleteAnggota(id)
            .then(response => {
                console.log(response.data)
            })
            .catch(e => {
                console.log(e);
            })
            location.reload();
        }else{
            alert(
                "Batal Menghapus!"
            )
        }
    },
    getAnggotaByIdKK(){
        let id_kk = this.$route.params.id;
        anggotaService.getAnggotaByIdKK(id_kk)
        .then((response) => {
            this.AnggotaData = response.data;
            console.log(this.AnggotaData);
        })
        .catch((e) =>{
            console.log(e);
        })
    },

}


};
</script>

<style>
</style>