FROM microbusiness/uihost-service
MAINTAINER microbusiness.ltd@gmail.com
ADD resources/public/signin.html /www/
ADD resources/public/js/compiled/useruiservice.js /www/js/compiled/
CMD ["/UIHostService"]