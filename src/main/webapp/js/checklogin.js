/**
 * 处理登录的信息返回
 */

let header_info = new Vue({
	el: "#header",
	data: {
		member: {}, // 登录信息
		onLogin: false, // 登录标志
		types: [], //商品分类信息
	},
	mounted: function(){
		axios.get("member/check").then(result=>{
			if(result.status == 200 && result.data.code == 200){
				this.onLogin = true;
				this.member = result.data.data;
			}else{
				this.onLogin = false;
			}
		});
		
		axios.get("types/finds").then(result=>{
			if(result.status ==200){
				this.types = result.data;
			}
		});
		
	}
});