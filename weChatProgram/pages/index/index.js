//index.js
//获取应用实例
const app = getApp()
const constant = require("../../utils/constant.js")
Page({
  data: {
    showLoading:true,
    showButton:false,
    loadingtext:"正在登录",
  },
  onLoad: function (options) {
    // 登录
    wx.login({
      success: res => {
        this.login_success(res);
      },
      fail: function (res) {
        console.log("login failed");
      }
    })
  },
  onReady: function () {
    // 页面渲染完成
  },
  onShow: function () {
    // 页面显示
  },
  onHide: function () {
    // 页面隐藏
  },
  onUnload: function () {
    // 页面关闭
  },
  get_user_info:function(){
    this.setData({ loadingtext:"正在获取用户信息"})
    wx.getUserInfo({
      success : res=>{
        app.globalData.userInfo = res.userInfo;
        this.redirectWindow()
      },
      fail : res=>{
        console.log(res);
      }
    })
  },
  login_success: function (res){
    wx.request({
      url: constant.golable_variable.getsession_url,
      data: {
        appid: constant.golable_variable.appid,
        secret: constant.golable_variable.appsecret,
        js_code: res.code,
        grant_type: "authorization_code"
      },
      success: res=> {
        // 获取用户信息
        app.globalData.session_key = res.data.session_key
        app.globalData.openid = res.data.openid
        this.get_session_success()
      },
      fail: res=> {
        console.log("get session failed");
      }
    })
  },
  get_session_success:function(){
    wx.getSetting({
      success: set_res => {
        if (set_res.authSetting["scope.userInfo"]) {
          this.get_user_info();
        }
        else {
          this.setData({
            showLoading : false,
            showButton:true})
        }
      }
    })
  },
  onGotUserInfo: function (e) {
    app.globalData.userInfo = e.detail.userInfo
    this.redirectWindow()
  },
  redirectWindow:function(){
    wx.redirectTo({
      url: "../vote_index/vote_index"
    })
  }
})
