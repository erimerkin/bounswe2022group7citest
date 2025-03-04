import 'package:android/models/user_model.dart';

import 'package:android/util/string_helpers.dart';

class ArtItemInfo {
  final int id;
  final String name;
  final String description;
  final String? category;
  final String? imageUrl;
  final List<String>? labels;

  ArtItemInfo({
    required this.id,
    required this.name,
    required this.description,
    this.category,
    this.imageUrl,
    this.labels,
  });

  factory ArtItemInfo.fromJson(Map<String, dynamic> json) {
    return ArtItemInfo(
      id: json['id'],
      name: json['name'] ?? "",
      description: json['description'] ?? "",
      category: json['category'] ?? "",
      imageUrl: json['imageUrl'] ?? "https://api.multiavatar.com/Robo.png",
      labels: stringToList(json['labels']),
    );
  }
}
