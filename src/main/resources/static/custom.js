let map;

function initMap() {
    map = new google.maps.Map(document.getElementById('map'), {
        center: coords,
        zoom: 10,
        scrollwheel: false
    });

    let image = {
        url: '/pointer.png',
        scaledSize: new google.maps.Size(30, 30)
    };

    let marker = new google.maps.Marker({
       position: coords,
       map: map,
       icon: image,
       animation: google.maps.Animation.BOUNCE
   });

   let contentString = '<h2>' + city + ', ' + state + '</h2>';

    let infowindow = new google.maps.InfoWindow({
      content: contentString
    });

    google.maps.event.addListener(marker, 'click', () => infowindow.open(map,marker));
}