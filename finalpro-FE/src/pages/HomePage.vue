.<template>
  <div>
    <SidebarComp></SidebarComp>
    <HomeComp></HomeComp>
  </div>
</template>

<script>
import SidebarComp from "../components/HommeComp.vue";

export default {
  name: "HomePage",
  components: {
    SidebarComp,
    HomeComp,
  },
};
</script>

<style>
</style>