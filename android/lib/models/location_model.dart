class Location {
  final int id;
  final double latitude;
  final double longitude;
  final String address;

  Location(
      {required this.id,
      required this.latitude,
      required this.longitude,
      required this.address});

  factory Location.fromJson(Map<String, dynamic> json) {
    return Location(
      id: json['id'],
      // typo from the back-end team, should be 'latitude'
      //latitude: json['latitude'],
      latitude: json['lattitude'],
      longitude: json['longitude'],
      address: json['address'],
    );
  }
}
