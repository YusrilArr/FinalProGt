.<template>
  <div>
    <div class="dashboard">
      <SidebarComp></SidebarComp>
      <div class="content">
        <FormtambahComp></FormtambahComp>
      </div>
    </div>
  </div>
</template>

<script>
import SidebarComp from "../components/layout/SidebarComp.vue";
import FormtambahComp from "../components/FormtambahComp.vue";

export default {
  name: "TambahkkPage",
  components: {
    SidebarComp,
    FormtambahComp,
  },
};
</script>

<style scoped>
.dashboard {
  display: grid;
  grid-template-columns: 1fr 5fr;
  background-color: teal;
  height: 100vh;
  width: 100vw;
}

.content {
  background-color: white;
  border-radius: 20px;
  margin-top: 15px;
  margin-right: 10px;
}
</style>