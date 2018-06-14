const request_url = {
  login: "user/weChatLogin"
}

const prev_url_dev = "http://localhost:8080/";
const prev_url_prd = "";

const getUrl_dev = url =>{
  return prev_url_dev + url;
}

const getUrl_prd = url =>{
  return prev_url_prd +url;
}

module.exports = {
  getUrl: getUrl_dev,
  request_url:request_url
}
